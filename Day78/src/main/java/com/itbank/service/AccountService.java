package com.itbank.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.components.SHA512;
import com.itbank.model.AccountDAO;
import com.itbank.model.AccountDTO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO dao;
	
	@Autowired
	private SHA512 hash;
	
	public List<AccountDTO> getAccounts() {
		return dao.selectAll();
	}

	public Map<String, Object> login(AccountDTO input, HttpSession session) 
			throws NoSuchAlgorithmException {
		Map<String, Object> map = new HashMap<>();
		String msg = "입력 정보를 다시 확인해주세요";
		int row = 0;
		
		input.setUserpw(hash.getHash(input.getUserpw()));
		input = dao.selectOne(input);
		
		if(input != null) {
			session.setAttribute("user", input);
			msg = input.getNick() + "님 로그인";
			row = 1;
		}
		
		map.put("msg", msg);
		map.put("row", row);
		
		return map;		
	}

	public int signUp(AccountDTO input) 
			throws NoSuchAlgorithmException {
		input.setUserpw(hash.getHash(input.getUserpw()));
		
		return dao.insert(input);
	}
	
	public int deleteAccounts(int idx) {
		return dao.delete(idx);
	}
	
	public int updateAccounts(AccountDTO input) 
			throws NoSuchAlgorithmException {
		input.setUserpw(hash.getHash(input.getUserpw()));
		return dao.update(input);
	}
	
	public String findAccount(String email) {
		List<String> ids = dao.selectEmail(email);
		String result = "이메일과 일치하는 아이디는 아래와 같습니다\\n";
		
		for (String id : ids) {
			result += id + "\\n";
		}
		
		return result;
	}

	public String findAccount(AccountDTO input) 
			throws NoSuchAlgorithmException {
		input = dao.selectAcc(input);
		String msg = "존재하지 않는 계정 정보입니다";
		
		if (input != null) {
			msg = RandomStringUtils.randomAlphanumeric(8);
			
			input.setUserpw(hash.getHash(msg));
			dao.update(input);
		}
		
		return msg;
	}
}

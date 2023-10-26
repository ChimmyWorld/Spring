package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.components.SHA512;
import com.itbank.model.AccountDAO;
import com.itbank.model.DTO.AccountDTO;

@Service
public class AccountService {
	
	@Autowired private AccountDAO dao;
	@Autowired private SHA512 hash;
	
	public String test() {
		return dao.banner();
	}
	
	public List<AccountDTO> getAccounts() {
		return dao.selectAll();
	}

	public AccountDTO getAccount(int idx) {
		return dao.selectOne(idx);
	}

	public int write(AccountDTO input) {
		String pw = hash.getHash(input.getUserpw());
		input.setUserpw(pw);
		
		return dao.insert(input);
	}
	
	public int update(AccountDTO input) {
		String pw = hash.getHash(input.getUserpw());
		input.setUserpw(pw);
		
		return dao.update(input);
	}

	public int delete(int idx) {
		return dao.delete(idx);
		
	}
}

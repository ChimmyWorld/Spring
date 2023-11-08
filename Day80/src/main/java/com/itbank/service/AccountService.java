package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.AccountDAO;
import com.itbank.model.vo.AccountDTO;

@Transactional // 클래스에 지정 시 모든 메서드가 적용
@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	@Transactional(readOnly = true) // 상세 설정이 우선시 됨
	public AccountDTO login(AccountDTO input) {
		return dao.selectOne(input);
	}

	public int signUp(AccountDTO input) {
		// dao.insert(input);
		// 예외발생을 위해 일부러 작성 (트랜잭션 디버깅용)
	
		return dao.insert(input);		
	}
}

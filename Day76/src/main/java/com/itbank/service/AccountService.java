package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.AccountDAO;
import com.itbank.model.AccountDTO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO dao;
	
	public List<AccountDTO> getAccounts() {
		return dao.selectAll();
	}

	public AccountDTO login(AccountDTO input) {
		return dao.selectOne(input);		
	}
}

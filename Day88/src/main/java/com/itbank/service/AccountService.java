package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.AccountDAO;

@Service
public class AccountService {
	@Autowired AccountDAO dao;
	
	public int isUserid(String userid) {
		return dao.selectUserid(userid);
	}

	public int isNick(String nick) {
		return dao.selectNick(nick);
	}

}

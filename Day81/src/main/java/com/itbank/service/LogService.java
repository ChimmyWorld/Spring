package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.DAO;

@Service
public class LogService {
	
	@Autowired
	private DAO dao;
	
	public String test() {
		return dao.test();
	}

}

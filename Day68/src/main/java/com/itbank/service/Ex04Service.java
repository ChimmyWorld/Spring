package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.Ex04DAO;
import com.itbank.model.DTO.PersonDTO;

@Service
public class Ex04Service {
	
	@Autowired
	private Ex04DAO dao;
	
	public String test() {
		return dao.banner();
	}
	
	public List<PersonDTO> getPersons() {
		return dao.selectAll();
	}
}

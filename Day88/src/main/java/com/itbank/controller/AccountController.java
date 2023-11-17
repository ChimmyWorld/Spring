package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.AccountVO;
import com.itbank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired private AccountService as;
	
	@PostMapping
	public int idCheck(@RequestBody AccountVO input) {		
		return as.isUserid(input.getUserid());
	}
	
	@PostMapping("/nick")
	public int nickCheck(@RequestBody AccountVO input) {
		return as.isNick(input.getNick());
	}
}

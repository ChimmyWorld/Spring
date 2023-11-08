package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.RemoveTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.vo.AccountDTO;
import com.itbank.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired private AccountService as;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(AccountDTO input, HttpSession session) {
		
		input = as.login(input);
		
		if(input != null) {
			session.setAttribute("user", input);
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	@GetMapping("/signUp")
	public void signUp() {
		
	}
	
	@PostMapping("/signUp")
	public String signUp(AccountDTO input) {
		as.signUp(input);
		
		return "redirect:/";
	}
}

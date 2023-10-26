package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.service.Ex04Service;

@Controller
public class Ex04Controller {
	
	@Autowired
	private Ex04Service es;
	
	@GetMapping("/ex04")
	public void ex04(Model model) {
		
		model.addAttribute("ver", es.test());
		model.addAttribute("list", es.getPersons());
	}
}

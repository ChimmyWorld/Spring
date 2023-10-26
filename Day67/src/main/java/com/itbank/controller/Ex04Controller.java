package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.beans.PersonDTO;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	
	@GetMapping
	public void ex04() {}
	
	@PostMapping
	public String ex04(Model model, PersonDTO per) {
		
		String msg = per.getName() + "님은 ";
		msg += per.getAge() >= 19 ? "성인" : "미성년자";
		msg += "입니다";	
		
		model.addAttribute("msg", msg);
		
		return "ex01_result";
	}
	
}

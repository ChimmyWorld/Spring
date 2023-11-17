package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/ajax")
	public void ajax() {}
	
	@GetMapping("/quiz")
	public void quiz() {}
	
	@GetMapping("/quiz2")
	public void quiz2() {}
}

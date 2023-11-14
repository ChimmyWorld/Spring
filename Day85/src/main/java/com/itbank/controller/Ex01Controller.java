package com.itbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.PersonVO;

@RestController				// Controller + ResponseBody
@RequestMapping("/person")

public class Ex01Controller {
	@GetMapping("/test")
	public String ex01() { 
		return "Hello Spring";
	}
	
	@PostMapping
	public PersonVO[] ex02() {
		PersonVO[] list = new PersonVO[] {
			new PersonVO(1, "홍길동", 30),
			new PersonVO(2, "김민지", 25),
		};
		
		return list;
	}
	
	@GetMapping("/{idx}")
	public PersonVO ex03(@PathVariable int idx) {
		
		return new PersonVO(idx, "홍길동", 30);
	}
}

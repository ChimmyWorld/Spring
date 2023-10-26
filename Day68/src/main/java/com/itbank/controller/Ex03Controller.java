package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Ex03Service;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired
	private Ex03Service es;
	
	@GetMapping
	public void ex03() {}
	
	@PostMapping
	public ModelAndView ex03(String name, int score) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("grade", es.getGrade(score));
		mav.setViewName("ex03_result");
		
		return mav;
	}	
}

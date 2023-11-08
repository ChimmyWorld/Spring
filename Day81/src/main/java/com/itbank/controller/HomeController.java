package com.itbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.LogService;

@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(getClass()); 
	
	@Autowired
	private LogService ls;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ver", ls.test());
		mav.setViewName("home");
		
		log.error("로그 : Error");
		log.warn("로그 : Warning");
		log.info("로그 : Information");
		log.debug("로그 : Debug");
		log.trace("로그 : trace");
		
		return mav;
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		log.trace("실행 완료~");
		return "ex01";
	}
}

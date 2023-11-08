package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired BoardService bs;
	
	@GetMapping({"/", "/{idx}"})
	public ModelAndView home(@PathVariable(required = false) Integer idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("map", bs.getBoards(idx));		// 최신 게시글 20개만
		mav.setViewName("home");
		
		return mav;
	}
	
	@GetMapping("/txTest")
	public String txTest() {
		bs.txTestRun();
		
		return "redirect:/";
	}
	
}

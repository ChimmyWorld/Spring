package com.itbank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.BoardDTO;
import com.itbank.service.BoardService;

@Controller
public class HomeController {
	@Autowired
	private BoardService bs;
	
	@GetMapping(value = {"/", "/{idx}"})
	public ModelAndView home(@PathVariable(required = false) Integer idx){
		// @required의 기본값은 true
		// - idx에 무조건 값이 전달되어야 한다
		// - false -> 값이 전달되지 않아도 된다 (null인 경우)
		
		ModelAndView mav = new ModelAndView("home");
		Map<String, Object> result = bs.getBoards(idx);
		
		mav.addObject("list", result.get("list"));
		mav.addObject("p", result.get("p"));
			
		return mav;
	}
}

package com.itbank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.BoardVO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired private BoardService bs;
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> result = bs.getBoard(idx);
		
		mav.addObject("row", result.get("row"));
		mav.addObject("rps", result.get("rps"));
		mav.setViewName("board/view");
		
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardVO input) {
		String path = bs.writeBoard(input);
		
		return "redirect:/board/" + path;
	}
}

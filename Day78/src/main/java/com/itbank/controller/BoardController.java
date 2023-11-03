package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.itbank.model.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@GetMapping("/list")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", bs.getBoards());
		
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("board/view");
		
		mav.addObject("row", bs.getBoard(idx));
		
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public ModelAndView write(BoardDTO input) {
		ModelAndView mav = new ModelAndView("message");
		
		mav.addObject("row", bs.addBoard(input));
		mav.addObject("msg", "작성 완료");
		mav.addObject("location", "board/list");
		
		return mav;
	}
}

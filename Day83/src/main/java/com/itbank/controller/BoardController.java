package com.itbank.controller;

import java.io.IOException;

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
	@Autowired
	BoardService bs;
	
	@GetMapping("/write")
	public void write() {
		
	}
	
	@PostMapping("/write")
	public String write(BoardVO input) throws IOException {
		bs.addBoard(input);
		
		return "redirect:/";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("board/view");
		
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx) throws IOException {
		bs.deleteBoard(idx);
		
		return "redirect:/";
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("board/write");
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(BoardVO input) throws IOException {
		bs.updateBoard(input);
		
		return "redirect:/board/view/" + input.getIdx();
	}
}

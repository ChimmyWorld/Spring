package com.itbank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired private BookService bs;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> param) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", bs.getBooks(param));
		
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {
		
	}
	
	@PostMapping("/add")
	public String add(BookDTO input) {		
		bs.addBook(input);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/update")
	public ModelAndView update(int idx) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", bs.getBook(idx));
		
		return mav;
	}
	
	@PostMapping("/update")
	public String update(BookDTO input) {
		ModelAndView mav = new ModelAndView();
	
		mav.addObject("row", bs.updateBook(input));
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/delete")
	public String delete(int idx) {
		bs.deleteBook(idx);
	
		return "redirect:/book/list";
	}
}

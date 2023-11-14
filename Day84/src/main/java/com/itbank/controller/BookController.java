package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.BookDAO;
import com.itbank.model.BookVO;
import com.itbank.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bs;
	
	@GetMapping
	public List<BookVO> getBooks(){
		return bs.getBooks();
	}
	
	@GetMapping("/{idx}")
	public BookVO getBook(@PathVariable int idx) {
		return bs.getBook(idx);
	}
	
	@PostMapping
	public int addBook(BookVO input) {
		System.out.println(input.getTitle());
		System.out.println(input.getWriter());
		System.out.println(input.getPublisher());
		System.out.println(input.getPrice());
		
		return 0;
	}
}

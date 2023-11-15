package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public int addBook(@RequestBody BookVO input) {
		return bs.addBook(input);
	}
	
	@PutMapping
	public int updateBook(@RequestBody BookVO input) {	
		
		return bs.updateBook(input);
	}
	
	@PatchMapping
	public int updateBookPrice(@RequestBody BookVO input) {
		return bs.updatePrice(input);
	}
	
	@DeleteMapping("/{idx}")
	public int deleteBook(@PathVariable int idx) { 		
		
		return bs.deleteBook(idx);
	}
	
}

package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.dto.BookDTO;

@Service
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public String getVer() {
		return dao.test();
	}

	public List<BookDTO> getBooks() {
		return dao.selectAll();
	}

	public int addBook(BookDTO input) {
		return dao.insert(input);
	}

	public int deleteBook(int idx) {
		return dao.delete(idx);
	}

	public BookDTO getBook(int idx) {
		return dao.selectOne(idx);
	}

	public int updateBook(BookDTO input) {
		return dao.update(input);
		
	}
	
}

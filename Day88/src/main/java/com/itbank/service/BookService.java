package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.BookVO;

@Service
public class BookService {
	@Autowired BookDAO dao;
	
	public List<BookVO> getBooks() {
		return dao.selectAll();
	}

	public BookVO getBook(int idx) {
		return dao.selectOne(idx);
	}

	public int addBook(BookVO input) {
		return dao.insert(input);
	}

	public int updateBook(BookVO input) {
		return dao.updateAll(input);
	}

	public int updatePrice(BookVO input) {
		return dao.updatePrice(input);
	}

	public int deleteBook(int idx) {
		return dao.delete(idx);
	}

}

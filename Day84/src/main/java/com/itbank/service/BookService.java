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

}

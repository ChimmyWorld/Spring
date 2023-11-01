package com.itbank.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.BookDTO;

@Service
public class BookService {
	@Autowired private BookDAO dao;
	
	public String getVersion() {
		return dao.test();
	}
	
	public List<BookDTO> getBooks(Map<String, Object> param){
		// 검색어가 없을 경우 null 대신 기본값을 지정해서 세팅
		/* if (param.get("search") == null) {
			param.put("type", "title");
			param.put("search", "");
		} */
		
		return dao.selectAll(param);
	}
	
	public BookDTO getBook(int idx) {
		return dao.selectOne(idx);
	}

	public int addBook(BookDTO input) {
		return dao.insert(input);
	}
	
	public int updateBook(BookDTO input) {
		return dao.update(input);
	}
	
	public int deleteBook(int idx) {
		return dao.delete(idx);
	}

}

package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public String getVer() {
		return dao.test();
	}
	
	public List<BoardDTO> getBoards() {
		return dao.selectAll();
	}
	
	public int writeBoard(BoardDTO input) {
		return dao.insert(input);
	}
	
	public int deleteBoard(int idx) {
		return dao.delete(idx);
	}

	public BoardDTO getBoard(int idx) {
		return dao.selectOne(idx);
	}

}

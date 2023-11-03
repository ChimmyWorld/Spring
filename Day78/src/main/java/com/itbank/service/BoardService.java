package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itbank.model.BoardDAO;
import com.itbank.model.BoardDTO;

@Service
public class BoardService {
	@Autowired
	BoardDAO dao;
	
	public List<BoardDTO> getBoards(){
		return dao.selectAll();
	}

	public BoardDTO getBoard(int idx) {
		return dao.selectOne(idx);
	}

	public int addBoard(BoardDTO input) {
		return dao.insert(input);
	}
}

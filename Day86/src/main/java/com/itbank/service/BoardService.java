package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;
import com.itbank.model.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public List<BoardVO> getBoards(int reqPage) {
		// 여기에 페이징 코드를 마저 작성
		
		
		return dao.selectAll();
	}

	public int addBoard(BoardVO input) {
		return dao.insert(input);
	}

	public int updateBoard(BoardVO input) {
		return dao.update(input);
	}

	public int updateBoardTitle(BoardVO input) {
		return dao.updateTitle(input);
	}

	public int deleteBoard(int idx) {
		return dao.delete(idx);
	}

	public BoardVO getBoard(int idx) {
		return dao.selectOne(idx);
	}


}

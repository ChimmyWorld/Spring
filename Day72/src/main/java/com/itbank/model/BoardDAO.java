package com.itbank.model;

import java.util.List;

import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {
	String test();

	List<BoardDTO> selectAll();
	
	BoardDTO selectOne(int idx);

	int insert(BoardDTO input);

	int delete(int idx);

	int update(BoardDTO input);
	
	int countUp(int idx);
	
}
package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.components.Paging;
import com.itbank.model.dto.BoardDTO;

public interface BoardDAO {
	String test();
	
	@Select("select count(*) from board")
	int totalBoard();

	List<BoardDTO> selectAll(Paging p);
	
	BoardDTO selectOne(int idx);
	
	int getAllBoard();

	int insert(BoardDTO input);

	int delete(int idx);

	int update(BoardDTO input);
	
	int countUp(int idx);
	
	
	
}
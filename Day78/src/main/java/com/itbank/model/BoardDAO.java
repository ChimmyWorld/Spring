package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardDAO {
	@Select("select count(*) from board")
	int totalBoard();
	
	public List<BoardDTO> selectAll();
	
	@Select("select * from board where idx = #{idx}")
	BoardDTO selectOne(int idx);

	int insert(BoardDTO input);
	
}

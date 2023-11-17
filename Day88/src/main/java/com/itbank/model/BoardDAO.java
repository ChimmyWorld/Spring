package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.components.Paging;

public interface BoardDAO {
	
	List<BoardVO> selectAll(Paging p);
	
	int insert(BoardVO input);

	int update(BoardVO input);

	int updateTitle(BoardVO input);

	int delete(int idx);
	
	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);

	@Select("select count(*) from board")
	int totalBoard();
}

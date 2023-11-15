package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardDAO {
	
	@Select("select * from board order by idx desc")
	List<BoardVO> selectAll();
	
	int insert(BoardVO input);

	int update(BoardVO input);

	int updateTitle(BoardVO input);

	int delete(int idx);
}

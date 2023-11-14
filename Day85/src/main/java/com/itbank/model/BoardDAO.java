package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardDAO {
	
	@Select("select * from board order by idx desc")
	List<BoardVO> selectAll();
}

package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.vo.BoardVO;

public interface BoardDAO {
	
	@Select("select banner from v$version")
	String test();
	
	@Select("select * from img_board where idx = #{idx}")
	BoardVO selectOne(int idx);
	
	@Select("select * from img_board order by idx desc")
	List<BoardVO> selectAll();

	int insert(BoardVO input);
	
	@Delete("delete from img_board where idx = #{idx}")
	int delete(int idx);
	
	int update(BoardVO input);
	
	String selectIdx();
	
}

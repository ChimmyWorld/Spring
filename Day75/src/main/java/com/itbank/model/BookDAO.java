package com.itbank.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface BookDAO {
	@Select("select banner from v$version")
	String test();
	
	@Select("select * from book where idx=#{idx}")
	BookDTO selectOne(int idx);
	
	int insert(BookDTO input);

	int update(BookDTO input);
	
	@Delete("delete from book where idx = #{idx}")
	int delete(int idx);
	
	List<BookDTO> selectAll(Map<String, Object> param);
	
}

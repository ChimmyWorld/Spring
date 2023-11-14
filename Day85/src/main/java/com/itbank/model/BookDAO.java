package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface BookDAO {
	
	@Select("select * from book order by idx desc")
	List<BookVO> selectAll();
	
	@Select("select * from book where idx = #{idx}")
	BookVO selectOne(int idx);

	int insert(BookVO input);

	int updateAll(BookVO input);

	int updatePrice(BookVO input);
	
	@Delete("delete from book where idx = #{idx}")
	int delete(int idx);

}

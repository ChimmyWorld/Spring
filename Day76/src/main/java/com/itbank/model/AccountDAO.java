package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AccountDAO {
	
	@Select("select * from account where idx = #{idx}")
	AccountDTO test(int idx);
	
	List<AccountDTO> selectAll();

	@Select("select * from account where userid = #{userid} and userpw = #{userpw}")
	AccountDTO selectOne(AccountDTO input);
	
}

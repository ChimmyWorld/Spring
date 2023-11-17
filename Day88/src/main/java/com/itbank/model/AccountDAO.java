package com.itbank.model;

import org.apache.ibatis.annotations.Select;

public interface AccountDAO {
	
	@Select("select count(*) from account where userid = #{userid}")
	int selectUserid(String userid);
	
	@Select("select count(*) from account where nick = #{nick}")
	int selectNick(String nick);
	
}

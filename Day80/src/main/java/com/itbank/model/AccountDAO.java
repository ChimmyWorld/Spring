package com.itbank.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.vo.AccountDTO;

public interface AccountDAO {
	@Select("select * from account where idx = #{idx}")
	AccountDTO test(int idx);
	
	@Select("select * from account where userid = #{userid} and userpw = #{userpw}")
	AccountDTO selectOne(AccountDTO input);
	
	@Insert("insert into "
			+ "account (userid, userpw, nick, email) "
			+ "values (#{userid}, #{userpw}, #{nick}, #{email}) ")
	int insert(AccountDTO input);

}

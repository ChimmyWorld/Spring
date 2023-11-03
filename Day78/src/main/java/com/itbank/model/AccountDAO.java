package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AccountDAO {
	
	@Select("select * from account where idx = #{idx}")
	public AccountDTO test(int idx);
	
	public List<AccountDTO> selectAll();
	
	@Select("select userid from account where email = #{email}")
	public List<String> selectEmail(String email);
	
	public AccountDTO selectOne(AccountDTO input);

	@Select("select * from account where userid = #{userid} and email = #{email}")
	public AccountDTO selectAcc(AccountDTO input);
	
	public int insert(AccountDTO input);

	public int delete(int idx);
	
	public int update(AccountDTO input);

	@Select("select * from account where userid = #{userid}")
	public AccountDTO selectTest(AccountDTO input);

}

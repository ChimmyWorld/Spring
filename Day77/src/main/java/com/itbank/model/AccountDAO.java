package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AccountDAO {
	
	@Select("select * from account where idx = #{idx}")
	public AccountDTO test(int idx);
	
	public List<AccountDTO> selectAll();

	public AccountDTO selectOne(AccountDTO input);

	public int insert(AccountDTO input);

	public int delete(int idx);
	
	public int update(AccountDTO input);

	public AccountDTO findId(AccountDTO input);
	
}

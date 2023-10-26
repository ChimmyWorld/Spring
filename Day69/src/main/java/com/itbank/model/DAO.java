package com.itbank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	@Autowired
	public JdbcTemplate jt;
	
	public String banner() {
		String sql = "select banner from v$version";
		return jt.queryForObject(sql, String.class);
	}
	
}
	
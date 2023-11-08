package com.itbank.model;

import org.apache.ibatis.annotations.Select;

public interface DAO {
	
	@Select("select banner from v$version")
	String test();

}

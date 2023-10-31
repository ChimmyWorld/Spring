package com.itbank.model;

import org.apache.ibatis.annotations.Select;

public interface BookDAO {
	@Select("select banner from v$version")
	String test();
}

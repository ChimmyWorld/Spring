package com.itbank.model.vo;

import org.apache.ibatis.annotations.Insert;

public interface FileDAO {
	
	@Insert("insert into " + 
			"upload(name, path, uploader, memo) " + 
			"values(#{name}, #{path}, #{uploader}, #{memo})")
	int insert(FileVO input);
	
}

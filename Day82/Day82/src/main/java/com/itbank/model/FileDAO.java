package com.itbank.model;

import org.apache.ibatis.annotations.Insert;

import com.itbank.model.vo.FileVO;

public interface FileDAO {
	
	@Insert("insert into " + 
			"upload(name, path, uploader, memo) " + 
			"values(#{name}, #{path}, #{uploader}, #{memo})")
	int insert(FileVO input);
	
}

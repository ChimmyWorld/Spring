package com.itbank.model.vo;
/*
IDX         NOT NULL NUMBER        
NAME        NOT NULL VARCHAR2(300) 
PATH        NOT NULL VARCHAR2(900) 
UPLOADER    NOT NULL VARCHAR2(150) 
MEMO                 VARCHAR2(150) 
UPLOAD_DATE          DATE

upload				파일 처리를 위한 필드
 */

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private int idx;
	private String name, path;
	private String uploader, memo;
	private Date upload_date;
	
	private MultipartFile upload;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

}

package com.itbank.model.dto;
/*
IDX        NOT NULL NUMBER        
TITLE      NOT NULL VARCHAR2(200) 
CONTENTS   NOT NULL CLOB          
WRITER     NOT NULL VARCHAR2(100) 
VIEW_COUNT          NUMBER        
WRITE_DATE          DATE          
 */

import java.sql.Date;

public class BoardDTO {
	private String title, writer, contents;
	private int idx, view_count;
	private Date write_date;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

}

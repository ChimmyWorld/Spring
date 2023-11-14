package com.itbank.model;
/*
IDX       NOT NULL NUMBER        
TITLE     NOT NULL VARCHAR2(300) 
WRITER    NOT NULL VARCHAR2(100) 
PUBLISHER NOT NULL VARCHAR2(100) 
P_DATE             DATE          
PRICE     NOT NULL NUMBER        
 */

import java.sql.Date;

public class BookVO {
	private int idx, price;
	private String title, writer, publisher;
	private Date p_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getP_date() {
		return p_date;
	}
	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

}

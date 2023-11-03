package com.itbank.components;

public class Paging {
	private int reqPage;
	private int offset, perCount = 10;

	public Paging(int reqPage, int totalBoard) {
		this.reqPage = reqPage;
		
		offset = (reqPage - 1) * perCount;
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
	}
	
	
}

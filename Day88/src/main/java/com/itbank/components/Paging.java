package com.itbank.components;

public class Paging {
	private int reqPage;
	private int totalBoard;
	private int perCount = 10;
	private int offset;
	private int totalPage;
	private int perPage = 10;
	private int section;
	private int begin, end;
	private boolean prev, next;
	
	public Paging(int reqPage, int totalBoard) {
		this.reqPage = reqPage;
		this.totalBoard = totalBoard;
		
		// 1. 오프셋
		offset = (reqPage -1) * perCount;
		
		// 2. 전체 페이지 수
		totalPage = totalBoard / perCount;
		totalPage += (totalBoard % perCount == 0) ? 0 : 1;
		
		// 3. 페이지 범위
		section = (reqPage -1 ) / perPage;
		begin = section * perPage + 1;
		end = (section + 1 ) * perPage;
		
		end = (end < totalPage) ? end : totalPage;
		
		prev = (section != 0);
		next = (end != totalPage);
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}

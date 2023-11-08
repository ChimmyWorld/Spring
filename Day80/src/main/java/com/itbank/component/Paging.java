package com.itbank.component;

public class Paging {
	private int reqPage;		// 요청 페이지
	private int offset;			// 게시글 시작점
	private int perCount = 10;	// 페이지당 게시글 수
	private int totalCount;		// 총 게시글 수
	private int totalPage;		// 총 페이지 수
	private int perPage = 10;	// 화면당 페이지 번호 수
	private int section;		// 페이지 번호 영역
	private int begin, end;		// 영역 시작/끝 번호
	
	public Paging(int reqPage, int totalCount) {
		this.reqPage = reqPage;
		this.totalCount = totalCount;
		
		offset = (reqPage - 1) * perCount;
		
		totalPage = totalCount / perPage;
		totalPage += (totalCount % perPage == 0) ? 0 : 1;
		
		section = (reqPage - 1) / perPage;
		begin = section * perPage + 1;
		end = (section + 1) * perPage;
		end = (end < totalPage) ? end : totalPage;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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

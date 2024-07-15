package com.sun.app.util;

public class Pager {
	private String kind;
	private String search;
//페이지 번호
	private Long page;
	private Long lastRow;
	private Long startRow;

//---------------------------------------
	private Long startNum;
	private Long lastNum;
	private Boolean pre;
	private Boolean next;
	private long perPage = 10L;

	public Long getPage() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

//rowNum 을 계산하는 메서드
	public void makeRow() throws Exception {
		this.startRow = (this.getPage() - 1L) * perPage + 1L;
		this.lastRow = page * perPage;
	}

	// 페이징 처리 하는 메서드
	public void makeNum(long totalCount) throws Exception {

		// 1.총개수를 이용해서 총 페이지 수 구하기
		long totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		}
		// 2. 총 페이지 수로 총 블럭 수 구하기
		long perBlock = 5L;// 한페이지에 보여질 페이지번호의 갯수
		long totalBlock = totalPage / perBlock; // 총 블럭의 수
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}
		// 3. 현재 페이지 번호로 현재 블럭 번호를 구하기

		// page 1 2 3 4 5 6 7 10 11
		// 블럭 번호 1 1 1 1 1 2 2 2 3
		long curBlock = 0;
		curBlock = page / perBlock;
		if (page % perBlock != 0) {
			curBlock++;
		}
		// 4.현재 블럭 번호로 시작 번호와 끝번호를 구한다
		// curBlock 1 2 3 4 5 6 7 8 9 10
		// startnum 1 6 11 16 21 26
		// lastnum 5 10 15 20 25 30
		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = perBlock * curBlock;

		// 5. 이전블럭 다음 블럭 유무 판단
		this.pre = true; // true면 이전 블럭이 존재, false면 이전 블럭이 x
		this.next = true; // true면 이전 블럭이 존재, false면 이전 블럭이 x
		if (curBlock == 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {
			next = false;
			lastNum = totalPage; // 마지막 페이지 수
		}
	}

	public long getPerPage() {
		return perPage;
	}

	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Boolean getPre() {
		return pre;
	}

	public void setPre(Boolean pre) {
		this.pre = pre;
	}

	public Boolean getNext() {
		return next;
	}

	public void setNext(Boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if (this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

}

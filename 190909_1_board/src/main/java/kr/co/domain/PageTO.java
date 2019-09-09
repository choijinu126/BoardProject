package kr.co.domain;

import java.util.List;

public class PageTO {
	private int amount;
	private int curPage;
	private int perPage;
	private int totalPage;
	private int startNum;
	private int endNum;
	private List<BoardVO> list;

	
	private int perLine;
	private int bpn; /* begin page number; */
	private int spn;
	private int lpg;
	
	
	public PageTO() {
		curPage = 1;
		perPage = 10;
		perLine = 10;
	}
	
	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		perPage = 10;
		perLine = 10;
	}

	public final int getAmount() {
		return amount;
	}
	
	private void change() {
		totalPage = (this.amount-1)/perPage +1;
		startNum = (curPage - 1) * perPage + 1;
		endNum = curPage * perPage;
		endNum = endNum < this.amount ? endNum : this.amount;
		
		bpn = ((curPage-1)/perLine) * perLine + 1;
		spn = ((curPage-1)/perLine + 1) * perLine;
		spn = spn < totalPage?spn:totalPage;
		lpg = ((totalPage)/perLine) * perLine;
	}
	
	public final int getLpg() {
		return lpg;
	}

	public final void setLpg(int lpg) {
		this.lpg = lpg;
	}

	public final void setAmount(int amount) {
		this.amount = amount;
		change();
	}

	public final int getPerLine() {
		return perLine;
	}

	public final void setPerLine(int perLine) {
		this.perLine = perLine;
		change();
	}

	public final int getBpn() {
		return bpn;
	}

	public final void setBpn(int bpn) {
		this.bpn = bpn;
	}

	public final int getSpn() {
		return spn;
	}

	public final void setSpn(int spn) {
		this.spn = spn;
	}

	public final int getCurPage() {
		return curPage;
	}

	public final void setCurPage(int curPage) {
		this.curPage = curPage;
		change();
	}

	public final int getPerPage() {
		return perPage;
	}

	public final void setPerPage(int perPage) {
		this.perPage = perPage;
		change();
	}

	public final int getTotalPage() {
		return totalPage;
	}

	public final void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public final int getStartNum() {
		return startNum;
	}

	public final void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public final int getEndNum() {
		return endNum;
	}

	public final void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public final List<BoardVO> getList() {
		return list;
	}

	public final void setList(List<BoardVO> list) {
		this.list = list;
	}	
}
package kr.co.domain;

public class SPageTO extends PageTO<BoardVO>{
	private String searchType;
	private String keyword;
	
	public SPageTO() {
		super();
	}

	public SPageTO(int curPage, String searchType, String keyword) {
		super(curPage);
		this.searchType = searchType;
		this.keyword = keyword;
		// TODO Auto-generated constructor stub
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}

package kr.co.domain;

import java.io.Serializable;

public class BoardDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	notice table
	private int pk_num;
	private String title;
	private String content;
	private int readcnt;
	private String writeday;
	private String category;
	
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}


	public BoardDTO(int pk_num, String title, String content, int readcnt, String writeday, String category) {
		super();
		this.pk_num = pk_num;
		this.title = title;
		this.content = content;
		this.readcnt = readcnt;
		this.writeday = writeday;
		this.category = category;
	}
	
	public BoardDTO(String category) {
		super();
		this.category = category;
	}


	public int getPk_num() {
		return pk_num;
	}


	public void setPk_num(int pk_num) {
		this.pk_num = pk_num;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getReadcnt() {
		return readcnt;
	}


	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}


	public String getWriteday() {
		return writeday;
	}


	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", readcnt=" + readcnt + ", writeday=" + writeday + ", category=" + category + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDTO other = (BoardDTO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}
}

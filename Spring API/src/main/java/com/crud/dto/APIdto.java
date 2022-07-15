package com.crud.dto;

public class APIdto {
	
	
	private long id = 0;
	private String content = "";
	
	
	public APIdto(long id, String content) {
		this.id=id;
		this.content=content;
	}
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	
}

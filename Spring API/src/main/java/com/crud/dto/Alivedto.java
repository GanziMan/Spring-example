package com.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alivedto {

	private String message;


	public Alivedto( String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

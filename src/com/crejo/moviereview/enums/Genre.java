package com.crejo.moviereview.enums;

public enum Genre {

	ACTION("0","Action"),COMEDY("1","Comedy");
	private String code;
	
	private String value;
	
	private Genre(String code,String value) {
		this.code = code;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getValue() {
		return value;
	}

}

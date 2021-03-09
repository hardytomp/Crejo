package com.crejo.moviereview.enums;

public enum UserType {

	VIEWER("0","Viewer"),CRITIC("1","Critc");
	private String code;
	
	private String value;
	
	private UserType(String code,String value) {
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

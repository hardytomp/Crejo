package com.crejo.moviereview.exceptions;

public class UserNotPresentException extends Exception{
	
	private String message;
	
	public UserNotPresentException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}

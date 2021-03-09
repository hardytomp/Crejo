package com.crejo.moviereview.exceptions;

public class AlreadyPresentException extends Exception{
	
	private String message;
	
	public AlreadyPresentException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}

package com.crejo.moviereview.exceptions;

public class MovieNotFoundException extends Exception{
	
	private String message;
	
	public MovieNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}

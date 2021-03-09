package com.crejo.moviereview.exceptions;

public class MultipleReviewsNotAllowedException extends Exception{
	
	private String message;
	
	public MultipleReviewsNotAllowedException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}

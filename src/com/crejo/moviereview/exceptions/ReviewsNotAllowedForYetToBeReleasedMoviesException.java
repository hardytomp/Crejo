package com.crejo.moviereview.exceptions;

public class ReviewsNotAllowedForYetToBeReleasedMoviesException extends Exception{
	
	private String message;
	
	public ReviewsNotAllowedForYetToBeReleasedMoviesException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}

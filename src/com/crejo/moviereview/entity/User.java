package com.crejo.moviereview.entity;

public class User {
	private String name;
	private int numberOfReviewsGiven;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfReviewsGiven() {
		return numberOfReviewsGiven;
	}
	public void setNumberOfReviewsGiven(int numberOfReviewsGiven) {
		this.numberOfReviewsGiven = numberOfReviewsGiven;
	}
	
	public User(String name, int numberOfReviewsGiven) {
		this.name = name;
		this.numberOfReviewsGiven = numberOfReviewsGiven;
	}
	
}

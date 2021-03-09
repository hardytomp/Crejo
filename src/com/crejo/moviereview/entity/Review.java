package com.crejo.moviereview.entity;

public class Review {

	private  User reviewedUser;
	private  Movie reviewdMovie;
	private  int Rating;
	public User getReviewedUser() {
		return reviewedUser;
	}
	public void setReviewedUser(User reviewedUser) {
		this.reviewedUser = reviewedUser;
	}
	public Movie getReviewdMovie() {
		return reviewdMovie;
	}
	public void setReviewdMovie(Movie reviewdMovie) {
		this.reviewdMovie = reviewdMovie;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public Review(User reviewedUser, Movie reviewdMovie, int rating) {
		this.reviewedUser = reviewedUser;
		this.reviewdMovie = reviewdMovie;
		Rating = rating;
	}
	
}

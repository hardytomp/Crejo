package com.crejo.moviereview.service;

import java.util.List;

import com.crejo.moviereview.exceptions.AlreadyPresentException;
import com.crejo.moviereview.exceptions.MovieNotFoundException;
import com.crejo.moviereview.exceptions.MultipleReviewsNotAllowedException;
import com.crejo.moviereview.exceptions.ReviewsNotAllowedForYetToBeReleasedMoviesException;
import com.crejo.moviereview.exceptions.UserNotPresentException;

public interface MovieReviewService {
	
	public  int addNewUser(String userName) throws AlreadyPresentException;
	public int addNewMovie(String movieName,int yearOfRelease,List<String> genre) throws AlreadyPresentException;
	public int addNewReview(String movieName,String UserName,int ratings) throws MultipleReviewsNotAllowedException, MovieNotFoundException, ReviewsNotAllowedForYetToBeReleasedMoviesException, UserNotPresentException; 
	
}

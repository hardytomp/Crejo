package com.crejo.moviereview.service;

import java.util.List;

import com.crejo.moviereview.dao.MovieDao;
import com.crejo.moviereview.dao.MovieDaoImpl;
import com.crejo.moviereview.dao.ReviewDao;
import com.crejo.moviereview.dao.ReviewDaoImpl;
import com.crejo.moviereview.dao.UserDao;
import com.crejo.moviereview.dao.UserDaoImpl;
import com.crejo.moviereview.entity.Movie;
import com.crejo.moviereview.entity.Review;
import com.crejo.moviereview.entity.User;
import com.crejo.moviereview.enums.UserType;
import com.crejo.moviereview.exceptions.AlreadyPresentException;
import com.crejo.moviereview.exceptions.MovieNotFoundException;
import com.crejo.moviereview.exceptions.MultipleReviewsNotAllowedException;
import com.crejo.moviereview.exceptions.ReviewsNotAllowedForYetToBeReleasedMoviesException;
import com.crejo.moviereview.exceptions.UserNotPresentException;

public class MovieReviewServiceImpl implements MovieReviewService{

	private MovieDao movieDao = new MovieDaoImpl();
	private ReviewDao reviewDao = new ReviewDaoImpl();
	private UserDao userDao  = new UserDaoImpl();
	
	
	@Override
	public int addNewUser(String userName) throws AlreadyPresentException {
		return userDao.saveUser(new User(userName, 0));
	}

	@Override
	public int addNewMovie(String movieName, int yearOfRelease, List<String> genre) throws AlreadyPresentException {
		return movieDao.saveMovie(new Movie(movieName, yearOfRelease, genre));
	}

	@Override
	public int addNewReview(String movieName, String userName, int ratings) throws MultipleReviewsNotAllowedException, MovieNotFoundException, ReviewsNotAllowedForYetToBeReleasedMoviesException, UserNotPresentException {
		if(reviewDao.getReview(movieName)!= null && reviewDao.getReview(movieName).stream().anyMatch(review -> review.getReviewedUser().getName().equals(userName))){
			throw new MultipleReviewsNotAllowedException("Multiple reviews not allowed !!This Movie" +movieName+" already reviewd by "+userName);
		}
		Movie reviewingMovie = movieDao.getMovie(movieName);
		if(reviewingMovie == null) {
			throw new MovieNotFoundException("Requested Movie "+movieName +"not found in the db!");
		}
		
		if(reviewingMovie.getYearOfrelease() >= 2021) {
			throw new ReviewsNotAllowedForYetToBeReleasedMoviesException("Requested movie "+movieName+" is yet to be released!");
		}
		
		User reviewer = userDao.getUser(userName);
		if(reviewer == null) {
			throw new UserNotPresentException("Requested user "+userName + "not present in the Db!!Please reggister user");
		}
		
		UserType usetype = getUserType(reviewer);
		reviewer.setNumberOfReviewsGiven(reviewer.getNumberOfReviewsGiven()+1);
		userDao.updateUser(reviewer);

		return reviewDao.saveReview(new Review(reviewer, reviewingMovie, ratings*getWeitage(usetype)));
	} 
	
	private UserType getUserType(User user) {
		if(user.getNumberOfReviewsGiven() > 3 ) 
			return UserType.CRITIC;
		return UserType.VIEWER;
	}
	
	private int getWeitage(UserType type) {
		if(type.equals(UserType.CRITIC))
			return 2;
		return 1;
	}

	@Override
	public String getUserEntitlements(String userName) {
		if(userDao.getUser(userName).getNumberOfReviewsGiven() > 3)
			return UserType.CRITIC.getValue();
		return UserType.VIEWER.getValue();
	}

	@Override
	public float getMovieRating(String movieName) {
		int noOfReviews = reviewDao.getReview(movieName).size();	
		return reviewDao.getReview(movieName).stream().map(rvw->rvw.getRating()).reduce(0, (a,b)->a+b)/noOfReviews;
	}
	

}

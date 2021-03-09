package com.crejo.moviereview.test;

import java.util.ArrayList;
import java.util.List;

import com.crejo.moviereview.exceptions.AlreadyPresentException;
import com.crejo.moviereview.exceptions.MovieNotFoundException;
import com.crejo.moviereview.exceptions.MultipleReviewsNotAllowedException;
import com.crejo.moviereview.exceptions.ReviewsNotAllowedForYetToBeReleasedMoviesException;
import com.crejo.moviereview.exceptions.UserNotPresentException;
import com.crejo.moviereview.service.MovieReviewService;
import com.crejo.moviereview.service.MovieReviewServiceImpl;

public class MovieReviewTest {

	public static void main(String[] args) throws AlreadyPresentException, MultipleReviewsNotAllowedException, MovieNotFoundException, ReviewsNotAllowedForYetToBeReleasedMoviesException, UserNotPresentException {
		MovieReviewService testObj = new MovieReviewServiceImpl();
		
		testObj.addNewUser("SRK");
		testObj.addNewUser("Salman");
		testObj.addNewUser("Deepika");
		
		System.out.println(">>>Added users successfully");
		
		List<String> action = new ArrayList<>();
		action.add("Action");
		List<String> drama = new ArrayList<>();
		drama.add("Drama");
		List<String> comedy = new ArrayList<>();
		drama.add("Comedy");
		List<String> romance = new ArrayList<>();
		drama.add("Romance");		
		List<String> actionAndComedy = new ArrayList<>();
		actionAndComedy.add("Action");
		actionAndComedy.add("Drama");
		

		
		testObj.addNewMovie("Don", 2006, actionAndComedy);
		testObj.addNewMovie("Tiger", 2008, drama);
		testObj.addNewMovie("Padmaavat", 2006, comedy);
		testObj.addNewMovie("Lunchbox", 2021, drama);
		testObj.addNewMovie("Guru", 2006, drama);
		testObj.addNewMovie("Metro", 2006, romance);
		
		System.out.println(">>>Added movies successfully");
		
		testObj.addNewReview("Don", "SRK", 2);
		testObj.addNewReview("Padmaavat", "SRK", 8);
		testObj.addNewReview("Don", "Salman", 5);
		testObj.addNewReview("Don", "Deepika", 9);
		testObj.addNewReview("Guru", "Deepika", 6);
		testObj.addNewReview("Don", "SRK", 10);
		testObj.addNewReview("Don", "SRK", 2);

		

	}

}

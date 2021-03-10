package com.crejo.moviereview.test;

import java.util.ArrayList;
import java.util.List;

import com.crejo.moviereview.enums.UserType;
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
		
		System.out.println("Test Adding Users "+(testAddUser(testObj)?"SUCCESSS":"FAILED"));
		System.out.println("Test Adding Movies "+(testAddMovie(testObj)?"SUCCESSS":"FAILED"));
		System.out.println("Test Adding Reviews "+(testAddReview(testObj)?"SUCCESSS":"FAILED"));
		System.out.println("Test Adding MultipleReviewBySameUser "+(testMultipleReviewsNotAllowedException(testObj)?"SUCCESSS":"FAILED"));
		System.out.println("Test Adding RevieForUpcoming movies "+(testReviewsNotAllowedForYetToBeReleasedMoviesException(testObj)?"SUCCESSS":"FAILED"));
		System.out.println("Test Adding User's entitlement "+(testUserEntitlements(testObj)?"SUCCESSS":"FAILED"));
		System.out.println("Test Adding movie Rating "+(testMovieRating(testObj)?"SUCCESSS":"FAILED"));
		

	}
	
	private static boolean testUserEntitlements(MovieReviewService testObj) {
		try {
			testObj.addNewReview("Guru", "SRK", 6);
			testObj.addNewReview("Metro", "SRK", 6);
			if(!testObj.getUserEntitlements("SRK").equals(UserType.CRITIC.getValue()))
				return false;
			
		} catch (MultipleReviewsNotAllowedException | MovieNotFoundException
				| ReviewsNotAllowedForYetToBeReleasedMoviesException | UserNotPresentException e) {
			return false;
		}
		return true;
	}
	
	private static boolean testMovieRating(MovieReviewService testObj) {
		testObj.getMovieRating("Don");
		return true;
	}	

	
	private static boolean testMultipleReviewsNotAllowedException(MovieReviewService testObj) {
		try {
			testObj.addNewReview("Don", "SRK", 10);
		} catch (MultipleReviewsNotAllowedException e1){ 
			return true;
		}catch( MovieNotFoundException
				| ReviewsNotAllowedForYetToBeReleasedMoviesException | UserNotPresentException e) {
			
		}
		return false;
	}
	
	private static boolean testReviewsNotAllowedForYetToBeReleasedMoviesException(MovieReviewService testObj) {
		try {
			testObj.addNewReview("Lunchbox", "SRK", 4);
			
		} catch (ReviewsNotAllowedForYetToBeReleasedMoviesException e1){ 
			return true;
		}catch( MovieNotFoundException
				 | UserNotPresentException | MultipleReviewsNotAllowedException e) {
			
		} 
		return false;
	}
	
	private static boolean testAddReview(MovieReviewService testObj)  {
		try {
			testObj.addNewReview("Don", "SRK", 2);
			testObj.addNewReview("Padmaavat", "SRK", 8);
			testObj.addNewReview("Don", "Salman", 5);
			testObj.addNewReview("Don", "Deepika", 9);
			testObj.addNewReview("Guru", "Deepika", 6);
		} catch (MultipleReviewsNotAllowedException | MovieNotFoundException
				| ReviewsNotAllowedForYetToBeReleasedMoviesException | UserNotPresentException e) {
			return false;
		}
	
		return true;
	}
	
	private static boolean testAddUser(MovieReviewService testObj)  {
		try {
			testObj.addNewUser("SRK");
			testObj.addNewUser("Salman");
			testObj.addNewUser("Deepika");
		} catch (AlreadyPresentException e) {
			return false;
		}	
		return true;
	}
	
	private static boolean testAddMovie(MovieReviewService testObj) {
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
		
		
		try {
			testObj.addNewMovie("Don", 2006, actionAndComedy);
			testObj.addNewMovie("Tiger", 2008, drama);
			testObj.addNewMovie("Padmaavat", 2006, comedy);
			testObj.addNewMovie("Lunchbox", 2021, drama);
			testObj.addNewMovie("Guru", 2006, drama);
			testObj.addNewMovie("Metro", 2006, romance);
		} catch (AlreadyPresentException e) {
			return false;
		}
		
		return true;
	}

}

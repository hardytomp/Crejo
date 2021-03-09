package com.crejo.moviereview.dao;

import java.util.List;

import com.crejo.moviereview.entity.Movie;
import com.crejo.moviereview.entity.Review;

public interface ReviewDao {
	
	public int saveReview(Review review);
	public List<Review> getReview(String movieName);

}

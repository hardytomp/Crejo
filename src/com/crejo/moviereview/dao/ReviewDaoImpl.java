package com.crejo.moviereview.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crejo.moviereview.entity.Review;

public class ReviewDaoImpl implements ReviewDao{
	
	private Map<String,List<Review>> data = new HashMap<>();

	@Override
	public int saveReview(Review review) {
		if(data.containsKey(review.getReviewdMovie().getName())) {
			data.get(review.getReviewdMovie().getName()).add(review);
		} else {
			List<Review> reviewList = new ArrayList<>();
			reviewList.add(review);
			data.put(review.getReviewdMovie().getName(), reviewList);
		}
		return data.get(review.getReviewdMovie().getName()).size();
	}

	@Override
	public List<Review> getReview(String movieName) {
		if(data.containsKey(movieName)) {
			return data.get(movieName);
		}
		return null;
	}

}

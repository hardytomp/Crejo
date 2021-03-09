package com.crejo.moviereview.dao;

import java.util.List;

import com.crejo.moviereview.entity.Movie;
import com.crejo.moviereview.exceptions.AlreadyPresentException;

public interface MovieDao {
	
	public int saveMovie(Movie movie) throws AlreadyPresentException;
	public Movie getMovie(String movieName);
	public List<Movie> getMovies();

}

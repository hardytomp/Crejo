package com.crejo.moviereview.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.crejo.moviereview.entity.Movie;
import com.crejo.moviereview.exceptions.AlreadyPresentException;

public class MovieDaoImpl implements MovieDao{
	
	Map<String,Movie> data = new HashMap<>();

	@Override
	public synchronized int saveMovie(Movie movie) throws AlreadyPresentException {
		if(!data.containsKey(movie.getName())) {
			data.put(movie.getName(), movie);
		}else {
			throw new AlreadyPresentException("Movie "+movie.getName()+" already present in Db!");
		}
		return data.size();
	}

	@Override
	public  Movie getMovie(String movieName) {
		if(data.containsKey(movieName)) {
			return data.get(movieName);
		}
		return null;
	}

	@Override
	public List<Movie> getMovies() {
		return data.values().stream().collect(Collectors.toList());
	}

}

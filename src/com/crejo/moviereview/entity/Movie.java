package com.crejo.moviereview.entity;

import com.crejo.moviereview.enums.*;
import java.util.List;

public class Movie {

	private String name;
	private int yearOfrelease;
	List<String> genre;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfrelease() {
		return yearOfrelease;
	}
	public void setYearOfrelease(int yearOfrelease) {
		this.yearOfrelease = yearOfrelease;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public Movie(String name, int yearOfrelease, List<String> genre2) {
		
		this.name = name;
		this.yearOfrelease = yearOfrelease;
		this.genre = genre2;
	}
	
}

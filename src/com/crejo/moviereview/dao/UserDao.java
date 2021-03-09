package com.crejo.moviereview.dao;

import java.util.List;

import com.crejo.moviereview.entity.Movie;
import com.crejo.moviereview.entity.User;
import com.crejo.moviereview.exceptions.AlreadyPresentException;
import com.crejo.moviereview.exceptions.UserNotPresentException;

public interface UserDao {

	public int saveUser(User user) throws AlreadyPresentException;
	public int updateUser(User user) throws UserNotPresentException;
	public User getUser(String userName);
	public List<User> getUsers();	
	
}

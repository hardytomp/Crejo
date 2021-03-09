package com.crejo.moviereview.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.crejo.moviereview.entity.Movie;
import com.crejo.moviereview.entity.User;
import com.crejo.moviereview.exceptions.AlreadyPresentException;
import com.crejo.moviereview.exceptions.UserNotPresentException;

public class UserDaoImpl implements UserDao{
	
	Map<String,User> data = new HashMap<>();

	@Override
	public int saveUser(User user) throws AlreadyPresentException {
		if(!data.containsKey(user.getName())) {
			data.put(user.getName(), user);
		}else {
			throw new AlreadyPresentException("User "+user.getName()+" already present in Db!");
		}
		return data.size();
	}

	@Override
	public User getUser(String userName) {
		if(data.containsKey(userName)) {
			return data.get(userName);
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		return data.values().stream().collect(Collectors.toList());
	}

	@Override
	public int updateUser(User user) throws UserNotPresentException {
		if(!data.containsKey(user.getName())) {
			throw new UserNotPresentException("User "+user+" not found in the db to update!");
		} else {
			data.put(user.getName(), user);
		}
		return data.size();
	}

}

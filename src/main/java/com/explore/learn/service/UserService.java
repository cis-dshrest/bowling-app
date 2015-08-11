package com.explore.learn.service;

import java.util.List;

import com.explore.learn.model.User;

public interface UserService {
	
	User findByUsername(String username);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserbyUsername(String username);

	List<User> findAllUsers(); 
	
	User findUserByFirstLast(String first, String last);

	boolean isUsernameUnique(String username);
	
}

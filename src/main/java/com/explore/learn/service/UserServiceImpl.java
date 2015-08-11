package com.explore.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.explore.learn.dao.UserDao;
import com.explore.learn.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		User entity = dao.findByUsername(user.getUsername());
		if(entity!=null){
			entity.setId(user.getId());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setPassword(user.getPassword());
			entity.setRole(user.getRole());
			entity.setIsActive(user.getIsActive());
		}
		
	}

	@Override
	public void deleteUserbyUsername(String username) {
		dao.deleteUserByUsername(username);
		
	}

	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public User findUserByFirstLast(String first, String last) {
		return dao.findUserByRealName(first, last);
	}

	@Override
	public boolean isUsernameUnique(String username) {
		User user = findByUsername(username);
		return (user == null);
	}

}

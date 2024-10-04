package com.yash.dao;

import java.util.ArrayList;

import com.yash.pojo.User;

public interface UserDAO {

	// saveUser
	// updateUser
	// getUserById
	// getAllUsers
	
	public void saveUser(User user);
	public User updateUser(User user);
	public User getUserById(int id);
	public ArrayList<User> getAllUser();
	
}
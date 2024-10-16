package com.yash.ngo_donation.dao;

import java.util.ArrayList;

import com.yash.ngo_donation.pojo.User;

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
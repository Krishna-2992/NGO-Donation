package com.yash.ngo_donation.service;

import com.yash.ngo_donation.pojo.User;

public interface UserService {
	
	public void saveUser(User user);
	public User updateUser(User user);
	public User getUser(String email, String password);
}

package com.yash.ngo_donation.serviceImpl;

import java.util.ArrayList;

import com.yash.ngo_donation.dao.UserDAO;
import com.yash.ngo_donation.daoImpl.UserDAOImpl;
import com.yash.ngo_donation.pojo.User;
import com.yash.ngo_donation.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDao; 
	
	public UserServiceImpl() {
		this.userDao = new UserDAOImpl();
	}
	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUser(String email, String password) {
		System.out.println("inside getUser"); 
		System.out.println("email: " + email);
		System.out.println("password: " + password);
		
		// Getting all the users
		ArrayList<User> users = userDao.getAllUser();
		
		for(User user: users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				System.out.println("user found!!");
				System.out.println("with name as: " + user.getName());
				return user;
			}
		}
		return new User();
	}

	
}

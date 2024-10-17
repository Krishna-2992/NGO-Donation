package com.yash.ngodonation.serviceimpl;


import com.yash.ngodonation.dao.UserDao;
import com.yash.ngodonation.daoimpl.UserDaoImpl;
import com.yash.ngodonation.domain.User;
import com.yash.ngodonation.service.UserService;

import java.util.ArrayList;


public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
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

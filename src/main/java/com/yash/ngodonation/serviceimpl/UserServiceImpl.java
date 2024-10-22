package com.yash.ngodonation.serviceimpl;


import com.yash.ngodonation.dao.UserDao;
import com.yash.ngodonation.daoimpl.UserDaoImpl;
import com.yash.ngodonation.domain.User;
import com.yash.ngodonation.service.UserService;

import java.util.ArrayList;
import java.util.List;


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
        System.out.println("inside getUser service");
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        return userDao.getUser(email, password);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userDao.getAllUsers();
        return users;
    }


}

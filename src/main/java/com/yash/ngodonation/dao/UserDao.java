package com.yash.ngodonation.dao;

import com.yash.ngodonation.domain.User;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public void saveUser(User user);
    public User updateUser(User user);
    public User getUser(String email, String password);
    public List<User> getAllUsers();
}
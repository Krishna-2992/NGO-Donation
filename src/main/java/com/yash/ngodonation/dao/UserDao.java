package com.yash.ngodonation.dao;

import com.yash.ngodonation.domain.User;
import java.util.ArrayList;

public interface UserDao {
    public void saveUser(User user);
    public User updateUser(User user);
    public User getUserById(int id);
    public ArrayList<User> getAllUser();
}
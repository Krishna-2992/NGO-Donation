package com.yash.ngodonation.service;

import com.yash.ngodonation.domain.User;

public interface UserService {

    public void saveUser(User user);
    public User updateUser(User user);
    public User getUser(String email, String password);
}

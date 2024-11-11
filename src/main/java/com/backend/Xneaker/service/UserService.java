package com.backend.Xneaker.service;

import com.backend.Xneaker.model.User;

import java.util.List;

public interface UserService {
    public User CreateUser(User user);
    public List<User> getAllUser();
    public String verifyUser(User user);
}

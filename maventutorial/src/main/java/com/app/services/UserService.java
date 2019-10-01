package com.app.services;

import com.app.entity.Users;

import java.util.List;

public interface UserService{
    public List<Users> getAllUser();
    public String login(String email, String password);
    public String register(String email, String password, String name, int age, String subscribed);
}
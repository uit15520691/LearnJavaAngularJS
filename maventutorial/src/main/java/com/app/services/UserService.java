package com.app.services;

import com.app.entity.Users;

import java.util.List;

public interface UserService{
    public List<Users> getAllUser();
    public int login(String email, String password);
}
package com.app.services.user;

import com.app.entity.Users;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<Users> getAllUser();

    public String login(String email, String password);

    public String register(String email, String password, String name, int age, String subscribed);

//    public Map<String, Object> getUserInfo(String email);
}
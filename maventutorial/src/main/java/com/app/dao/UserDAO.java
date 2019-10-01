package com.app.dao;

import com.app.entity.Users;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserDAO {
    public List<Users> getAllUsers();

    public int login(String email, String password);

    public int register(String email, String password, String name, int age, String subscribed);
}


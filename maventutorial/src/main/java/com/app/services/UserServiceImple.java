package com.app.services;

import com.app.dao.UserDAO;
import com.app.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImple implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public List<Users> getAllUser() {

        return userDAO.getAllUsers();
    }
    public int login(String email, String password){
        return  userDAO.login(email, password);
    }
}

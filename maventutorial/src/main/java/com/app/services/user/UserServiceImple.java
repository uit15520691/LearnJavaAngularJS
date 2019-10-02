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

    public String login(String email, String password) {
        int loginResult = userDAO.login(email,password);
        if(loginResult==1){
            return "succeeded";
        }
        return "failed";
    }

    public String register(String email, String password, String name, int age, String subscribed){
        if(password.isEmpty()||email.isEmpty()){
            return "failed";
        }
        int isSuccess = userDAO.register(email, password, name,age, subscribed);
        if (isSuccess==0)
        {
            return "succeeded";
        }
        return "failed";
    }
}

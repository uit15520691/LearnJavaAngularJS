package com.app.services.user;

import com.app.dao.user.UserDao;
import com.app.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImple implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<Users> getAllUser() {

        return userDao.getAllUsers();
    }

    public String login(String email, String password) {
        int loginResult = userDao.login(email, password);
        if (loginResult == 1) {
            return "succeeded";
        }
        return "failed";
    }

    public String register(String email, String password, String name, int age, String subscribed) {
        if (password.isEmpty() || email.isEmpty()) {
            return "failed";
        }
        int isSuccess = userDao.register(email, password, name, age, subscribed);
        if (isSuccess == 0) {
            return "succeeded";
        }
        return "failed";
    }

//    public Map<String, Object> getUserInfo(String email){
//        return userDao.getUserInfo(email);
//    }
}

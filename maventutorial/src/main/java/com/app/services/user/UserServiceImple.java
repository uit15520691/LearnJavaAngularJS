package com.app.services.user;

import com.app.dao.user.UserDao;
import com.app.entity.UserInfo;
import com.app.entity.Users;
import com.app.models.LoginDTO;
import com.app.models.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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

    public Map<String, Object> login(LoginDTO accountInfo) {
        String email = accountInfo.getEmail();
        String password = accountInfo.getPassword();

        // chua tao duoc token nen dung email
        String loginEmail = userDao.login(email, password);
        Map<String, Object> result = new HashMap<>();
        if (loginEmail != null) {
            result.put("Succeeded", loginEmail);
            return result;
        }
        result.put("Failed", loginEmail);
        return result;
    }

    public Map<String, UserInfo> register(RegisterDTO accountInfo) {
        String email = accountInfo.getEmail();
        String password = accountInfo.getPassword();
        String name = accountInfo.getName();
        String country = accountInfo.getCountry();
        String sdt = accountInfo.getSdt();
        String subscribed = accountInfo.getSubscribed();
        int age = accountInfo.getAge();

        Map<String, UserInfo> result = new HashMap<>();
        if (password.isEmpty() || email.isEmpty()) {
            result.put("Failed", null);
            return result;
        }

        Users user = new Users(email, password, subscribed);
        UserInfo userInfo = new UserInfo(email, name, country, sdt, age);
        user.setUserInfo(userInfo);
        if (userDao.register(user) != -1) {
            result.put("Succeeded", userInfo);
            return result;
        }
        result.put("Failed", null);
        return result;
    }

    public Users getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public UserInfo getUserInfo(String email) {
        return userDao.getUserInfo(email);
    }
}

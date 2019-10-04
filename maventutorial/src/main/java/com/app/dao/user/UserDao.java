package com.app.dao.user;

import com.app.entity.UserInfo;
import com.app.entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserDao {
    public List<Users> getAllUsers();

    public String login(String email, String password);

    public int register(Users user);
    public Users getUserByEmail(String email);

    public Object getUserInfo(String email);
}

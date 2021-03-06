package com.app.services.user;

import com.app.entity.UserInfo;
import com.app.entity.Users;
import com.app.models.LoginDTO;
import com.app.models.RegisterDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<Users> getAllUser();

    public Map<String, Object> login(LoginDTO accountInfo);

    public Map<String, UserInfo> register(RegisterDTO userInfo);

    public UserInfo getUserInfo(String email);
    public Users getUserByEmail(String email);
    public Object getAuditLog();
    public Object getAuditLog(int revision);
}
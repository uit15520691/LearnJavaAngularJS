package com.app.services.usage;

import com.app.entity.User_Room;

import java.util.List;
import java.util.Map;

public interface UsageService {
    public List<User_Room> getAllUsage();

    public Map<String, User_Room> registerUsage(int id, String email);
}

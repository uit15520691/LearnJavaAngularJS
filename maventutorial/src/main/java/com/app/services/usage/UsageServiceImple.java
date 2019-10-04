package com.app.services.usage;

import com.app.dao.usage.UsageDao;
import com.app.entity.User_Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsageServiceImple implements UsageService {
    @Autowired
    UsageDao usageDao;

    public List<User_Room> getAllUsage() {
        return usageDao.getAllUsage();
    }

    public Map<String, User_Room> registerUsage(int roomID, String userEmail) {
        User_Room userRoom = usageDao.registerUsage(roomID, userEmail);
        Map<String, User_Room> map = new HashMap<String, User_Room>();
        if (userRoom != null) {
            map.put("Succeeded", userRoom);
        } else {
            map.put("Failed", userRoom);
        }
        return map;
    }
}

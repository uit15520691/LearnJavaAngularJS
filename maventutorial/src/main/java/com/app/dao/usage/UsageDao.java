package com.app.dao.usage;

import com.app.entity.User_Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UsageDao {
    public List<User_Room> getAllUsage();

    public User_Room registerUsage(int id, String email);
}

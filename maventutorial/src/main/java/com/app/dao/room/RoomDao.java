package com.app.dao.room;

import com.app.entity.Rooms;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface RoomDao {
    public Rooms findRoomByID(int id);
    public Rooms findRoomByName(String name);
    public List<Rooms> findAllroom();
    public int removeRoomByID(int id);
    public int addRoom(String name, int floor);
    public Rooms findLastRoom();
}

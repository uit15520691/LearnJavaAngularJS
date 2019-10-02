package com.app.services.room;

import com.app.dao.room.RoomDao;
import com.app.entity.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoomServiceImple implements RoomService {
    @Autowired
    private RoomDao roomDao;

    public Rooms findRoomByID(int id){
        return roomDao.findRoomByID(id);
    }

    public Rooms findRoomByName(String name){
        return roomDao.findRoomByName(name);
    }
    public List<Rooms> findAllroom(){
        return roomDao.findAllroom();
    }
    public String removeRoomByID(int id){
        int result = roomDao.removeRoomByID(id);
        if(result== 0){
            return "succeeded";
        }
        return "failed";
    }

    public String addRoom(String name, int floor){
        int result = roomDao.addRoom(name,floor);
        if(result== 0){
            return "succeeded";
        }
        return "failed";
    }

    public Rooms findLastRoom()
    {
        return roomDao.findLastRoom();
    }
}

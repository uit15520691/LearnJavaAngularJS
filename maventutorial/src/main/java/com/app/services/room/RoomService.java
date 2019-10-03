package com.app.services.room;

import com.app.entity.Rooms;

import java.util.List;


public interface RoomService {
    public Rooms findRoomByID(int id);

    public Rooms findRoomByName(String name);

    public List<Rooms> findAllRooms();

    public String removeRoomByID(int id);

    public String addRoom(String name, int floor);

    public Rooms findLastRoom();
}
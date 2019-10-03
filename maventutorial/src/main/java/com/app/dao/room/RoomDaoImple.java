package com.app.dao.room;

import com.app.entity.Rooms;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDaoImple implements RoomDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Rooms findRoomByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        Rooms room = session.get(Rooms.class, id);
        return room;
    }

    public Rooms findRoomByName(String name) {
        String queryString = "Select * from `rooms` where `name`= '" + name + "'";
        Session session = sessionFactory.getCurrentSession();
        List<Rooms> rooms = session.createNativeQuery(queryString, Rooms.class).list();
        return rooms.get(0);
    }

    public List<Rooms> findAllRooms() {
        String queryString = "Select * from `rooms`";
        Session session = sessionFactory.getCurrentSession();
        List<Rooms> rooms = session.createNativeQuery(queryString, Rooms.class).list();
        return rooms;
    }

    public int removeRoomByID(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Rooms room = session.get(Rooms.class, id);
            session.delete(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    public int addRoom(String name, int floor) {
        try (Session session = sessionFactory.openSession()) {
            Rooms room = new Rooms();
            room.setName(name);
            room.setFloor(floor);
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    public Rooms findLastRoom() {
        String queryString = "SELECT * FROM `rooms` ORDER BY `id` DESC LIMIT 1";
        Session session = sessionFactory.getCurrentSession();
        List<Rooms> rooms = session.createNativeQuery(queryString, Rooms.class).list();
        return rooms.get(0);
    }
}

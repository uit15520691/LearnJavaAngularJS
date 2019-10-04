package com.app.dao.usage;

import com.app.dao.room.RoomDao;
import com.app.dao.user.UserDao;
import com.app.entity.Rooms;
import com.app.entity.User_Room;
import com.app.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsageDaoImple implements UsageDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;

    @Autowired
    RoomDao roomDao;

    public List<User_Room> getAllUsage() {
        String queryString = "SELECT * FROM `usage`";
        Session session = sessionFactory.getCurrentSession();
        List<User_Room> userRoom = session.createNativeQuery(queryString).list();
     return userRoom;
    }


    @Transactional
    public User_Room registerUsage( int roomID, String userEmail) {
        User_Room userRoom = null;
        try (Session session = sessionFactory.openSession()){
            Users user = userDao.getUserByEmail(userEmail);
            Rooms room = roomDao.findRoomByID(roomID);
            if (user == null || room== null){
                System.out.println("Room or User not exist!");
                return null;
            }
            session.beginTransaction();
//            String queryString = "INSERT INTO `user_room` values("+ roomID+", '"+userEmail+"')";
//            session.createNativeQuery(queryString,User_Room.class).list().get(0);
            userRoom = new User_Room(roomID,userEmail);
            session.save(userRoom);
            session.getTransaction().commit();

        }
        catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
        return userRoom;

    }
}

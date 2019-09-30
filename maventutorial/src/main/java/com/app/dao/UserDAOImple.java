package com.app.dao;

import com.app.entity.Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDAOImple implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Users> list = session.createCriteria(Users.class).list();
        return list;
    }
    public int login(String email,String password){
        String queryString = "Select id from users " +
                "where email= "+(char)34+email+(char)34+" and password= "+(char)34+password+(char)34;
        System.out.println(queryString);
        Session session = sessionFactory.getCurrentSession();
        List<Integer> id = session.createNativeQuery(queryString).list();
        if(id.isEmpty()){
            return 0;
        }
        return id.get(0);
    }

}

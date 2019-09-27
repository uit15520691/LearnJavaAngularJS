package com.app.dao;

import com.app.entity.Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}

package com.app.dao.user;

import com.app.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImple implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Users> list = session.createCriteria(Users.class).list();
        return list;
    }

    public int login(String email, String password) {
        String queryString = "Select `email` from `users` " +
                "where `email`= '" + email + "' and `password`= '" + password + "'";
        Session session = sessionFactory.openSession();
        List<String> result = session.createNativeQuery(queryString).list();
        if (result.isEmpty()) {
            return 0;
        }
        return 1;
    }

    @Transactional
    public int register(String email, String password, String name, int age, String subscribed) {
        Users user = new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setAge(age);
        user.setSubscribed(subscribed);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            return -1;
        }

        return 0;
    }
}

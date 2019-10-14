package com.app.dao.user;

import com.app.entity.UserInfo;
import com.app.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImple implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> getAllUsers() {
        String queryString = "SELECT * FROM `users`";
        Session session = sessionFactory.getCurrentSession();
        List<Users> list = session.createNativeQuery(queryString).list();
        return list;
    }

    public String login(String email, String password) {
        String queryString = "Select `email` from `users` " +
                "where `email`= '" + email + "' and `password`= '" + password + "'";
        Session session = sessionFactory.openSession();
        List<String> result = session.createNativeQuery(queryString).list();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @Transactional
    public int register(Users user) {
        try(Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return -1;
        }
        return 0;
    }

    public UserInfo getUserInfo(String email) {
        String queryString = "SELECT `usr.email`, `i.name`, `i.contry`, `i.sdt`  FROM `user usr`" +
                "INNER JOIN `userinfo` t " +
                "WHERE `usr.email` = `usr.email`";
        Session session = sessionFactory.getCurrentSession();
        UserInfo info = session.createNativeQuery(queryString, UserInfo.class).list().get(0);
        return info;
    }

    @Transactional
    public Users getUserByEmail(String email){
        String queryString = "SELECT * FROM `users` " +
                "WHERE `email` = '"+email+"'";
        List<Users> user = new ArrayList<>();
        try{
            Session session = sessionFactory.getCurrentSession();
            user =session.createNativeQuery(queryString, Users.class).list();
        }
        catch (Exception e){
            System.out.println(e.getCause());
            throw e;
        }

        return user.get(0);
    }

    public Object getAuditLog(){
        Object usersList = null;
        Session session = sessionFactory.getCurrentSession();
        try{
            AuditReader auditReader = AuditReaderFactory.get(session);
            AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Users.class,true, true);
            usersList =  auditQuery.getResultList();
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }
        return usersList;
    }

    public Object getAuditLog(int revision){
        Object usersList;
        try(Session session = sessionFactory.openSession()){
            AuditReader auditReader = AuditReaderFactory.get(session);
            AuditQuery auditQuery = auditReader.createQuery().forEntitiesAtRevision(Users.class,revision);
            usersList =  auditQuery.getSingleResult();
        }
        return usersList;
    }
}

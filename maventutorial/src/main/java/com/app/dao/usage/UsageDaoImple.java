package com.app.dao.usage;

import com.app.entity.Usage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsageDaoImple implements UsageDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Usage> getAllUsage() {
        String queryString = "SELECT * FROM `usage`";
        Session session = sessionFactory.getCurrentSession();
        List<Usage> usage = session.createNativeQuery(queryString).list();
        return usage;
    }

    @Transactional
    public Usage registerUsage(int id, String email) {
        Usage usage = new Usage();
        usage.setRoomID(id);
        usage.setUserEmail(email);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(usage);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return usage;
    }
}

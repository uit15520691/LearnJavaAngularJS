package com.app.dao;

import com.app.dao.user.UserDaoImple;
import com.app.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @InjectMocks
    UserDaoImple userDao = new UserDaoImple();

    @Mock
    SessionFactory sessionFactory;

    @Test
    public void testRegister_success(){
        // Given
        Users user = new Users("quang@gmail.com","123456", "yes");

        Session mockSession = mock(Session.class);
        when(sessionFactory.openSession()).thenReturn(mockSession);

        Transaction mockTransaction = mock(Transaction.class);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);

        Serializable mockSerializable = mock(Serializable.class);
        when(mockSession.save(user)).thenReturn(mockSerializable);

        when(mockSession.getTransaction()).thenReturn(mockTransaction);

        // Then
        int result = userDao.register(user);

        // When
//        verify(mockSession,times(1)).save(user);
        assertEquals(result,0);
    }

    @Test
    public void testRegister_fail(){
        // Given
        Users user = new Users("quang@gmail.com","123456", "yes");

        Session mockSession = mock(Session.class);
        when(sessionFactory.openSession()).thenReturn(mockSession);

        Transaction mockTransaction = mock(Transaction.class);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);

        when(mockSession.save(user)).thenThrow(Exception.class);

        // When
        int result = userDao.register(user);

        // Then
        assertEquals(result,-1);
    }

    @Test
    public void testGetUserByEmail_success(){
        // Given
        String email = "quang@gmail.com";
        String queryString = "SELECT * FROM `users` " +
                "WHERE `email` = '"+email+"'";

        Session mockSession = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(mockSession);

        NativeQuery mockNativeQuery = mock(NativeQuery.class);
        when(mockSession.createNativeQuery(queryString,Users.class)).thenReturn(mockNativeQuery);

        List<Users> mockList = mock(ArrayList.class);
        Users mockUser = mock(Users.class);
        mockList.add(mockUser);
        when(mockNativeQuery.list()).thenReturn(mockList);
        when(userDao.getUserByEmail(email)).thenReturn(mockUser);

        // When
        Users actualUser = userDao.getUserByEmail(email);

        // Then
//        verify(mockSession.createNativeQuery(queryString,Users.class),times(1)).list();
        assertNotNull(actualUser);
    }

    @Test
    public void testGetUserByEmail_fail(){
        // Given
        String email = "quang@gmail.com";
        String queryString = "SELECT * FROM `users` " +
                "WHERE `email` = '"+email+"'";

        Session mockSession = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(mockSession);

        NativeQuery mockNativeQuery = mock(NativeQuery.class);
        when(mockSession.createNativeQuery(queryString,Users.class)).thenThrow(Exception.class);

        // When
        try{
            Users actualUser = userDao.getUserByEmail(email);
            fail();
        }
        // Then
        catch (Exception e){
            assertNotNull(e);
        }


    }

}

package com.app.service;

import com.app.dao.user.UserDao;
import com.app.entity.UserInfo;
import com.app.models.RegisterDTO;
import com.app.services.user.UserServiceImple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImple userService = new UserServiceImple();

    @Mock
    private UserDao userDao;

//    @Before
//    public void  setUp () throws Exception{
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testRegister_success() {
        // Given
        RegisterDTO registerDTO = new RegisterDTO("quang@gmail.com", "123456", "quang nguyen", "viet nam", 12, "yes", "0814567890");
        when(userDao.register(anyObject())).thenReturn(0);

        // When
        Map<String, UserInfo> result = userService.register(registerDTO);

        // Then
        UserInfo actualUserInfo = result.get("Succeeded");
        assertNotNull(actualUserInfo);
        assertEquals(actualUserInfo.getEmail(), registerDTO.getEmail());
    }

    @Test
    public void testRegister_fail() {
        // Given
        RegisterDTO registerDTO = new RegisterDTO("quang@gmail.com", "123456", "quang nguyen", "viet nam", 12, "yes", "0814567890");
        when(userDao.register(anyObject())).thenReturn(-1);

        // When
        Map<String, UserInfo> result = userService.register(registerDTO);

        // Then
        assertTrue(result.containsKey("Failed"));
    }
}

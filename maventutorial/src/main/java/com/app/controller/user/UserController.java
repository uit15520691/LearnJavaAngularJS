package com.app.controller.user;

import com.app.entity.Users;
import com.app.models.LoginDTO;
import com.app.models.RegisterDTO;
import com.app.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "Welcome To HomePage!";
    }

    @RequestMapping(value = "/users", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Object> getAllUser() {
        List<Users> users = userService.getAllUser();
        if (!users.isEmpty()) {
            return new ResponseEntity<Object>(users, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ResponseEntity<Object> login(@RequestBody LoginDTO accountInfo) {
        return new ResponseEntity<Object>(userService.login(accountInfo), HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseEntity<Object> register(@RequestBody RegisterDTO userInfo) {
        return new ResponseEntity<Object>(userService.register(userInfo), HttpStatus.OK);
    }
}

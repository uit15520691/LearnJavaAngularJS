package com.app.controller;

import com.app.entity.Users;
import com.app.models.LoginForm;
import com.app.models.LoginResponse;
import com.app.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "Welcome To HomePage!";
    }

    @RequestMapping(value = "/users", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> users = userService.getAllUser();
        if (!users.isEmpty()) {
            return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
        }
        return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ResponseEntity<LoginResponse> login(@RequestBody LoginForm input){
        int id= userService.login(input.getEmail(),input.getPassword());
        LoginResponse loginResponse = new LoginResponse(id);
        return new ResponseEntity<LoginResponse>(loginResponse,HttpStatus.OK);
    }
}

package com.app.controller.user;

import com.app.entity.Users;
import com.app.models.LoginForm;

import com.app.models.RegisterForm;
import com.app.models.Response;
import com.app.services.user.UserService;


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
    public ResponseEntity<Response> login(@RequestBody LoginForm input){
        String result= userService.login(input.getEmail(),input.getPassword());
        Response Response = new Response("login",result, input.getEmail());
        return new ResponseEntity<Response>(Response,HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseEntity<Response> register(@RequestBody RegisterForm input){
        String result= userService.register(input.getEmail(),input.getPassword(), input.getName(), input.getAge(),input.getSubscribed());
        Response registerResponse = new Response("register",result,input.getEmail());
        return new ResponseEntity<Response>(registerResponse,HttpStatus.OK);
    }
}

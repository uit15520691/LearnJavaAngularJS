package com.app.controller.user;

import com.app.dao.user.UserDao;
import com.app.entity.Users;
import com.app.models.LoginDTO;
import com.app.models.RegisterDTO;
import com.app.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getAuditLog", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuditLog(){
        Object returnObject = userService.getAuditLog();
        System.out.println(returnObject);
        return  new ResponseEntity<Object>(returnObject, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAuditLog/{revision}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuditLog(@PathVariable("revision") int revision){
        Object returnObject = userService.getAuditLog(revision);
        System.out.println(returnObject);
        return  new ResponseEntity<Object>(returnObject, HttpStatus.OK);
    }
}

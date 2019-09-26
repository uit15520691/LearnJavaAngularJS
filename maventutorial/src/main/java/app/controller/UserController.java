package app.controller;

import app.models.*;
import app.services.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(){
        return "Welcome To HomePage!";
    }

    @RequestMapping(value="/users", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity <List<User>> getAllUser(){
        List<User> users = userService.findAllUsers();
        if(!users.isEmpty()){
            return new ResponseEntity<List<User>>(users,HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity <User> getUserByID(@PathVariable("id") long id){
        User user = userService.findById(id);
        if(user!=null){
            return new ResponseEntity<User>(user, HttpStatus.FOUND);
        }
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/FindUserByName", method = RequestMethod.POST)
    public ResponseEntity<String> testApi(@RequestBody String req){
        if (req==""){
            return new ResponseEntity<String>("Request: NULL",HttpStatus.OK);
        }
        return new ResponseEntity<String>("request la "+req,HttpStatus.OK);
    }
}

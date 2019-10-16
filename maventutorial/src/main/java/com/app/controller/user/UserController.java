package com.app.controller.user;

import com.app.entity.Users;
import com.app.jwt.JwtProvider;
import com.app.models.LoginDTO;
import com.app.models.RegisterDTO;
import com.app.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

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

    @RequestMapping(value = "/user/abc", method = {RequestMethod.POST})
    public ResponseEntity<String> login(@RequestBody LoginDTO accountInfo) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountInfo.getEmail(), accountInfo.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken((User) authentication.getPrincipal());
        return new ResponseEntity<String>(jwt, HttpStatus.OK);
    }

    // @RequestMapping(value = "/login", method = {RequestMethod.POST})
    // public ResponseEntity<Object> login(@FormDataParam("name") String name,
    //                                     @FormParam("age") int age) {
    //     return new ResponseEntity<Object>(userService.login(accountInfo), HttpStatus.OK);
    // }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseEntity<Object> register(@RequestBody RegisterDTO userInfo) {
        return new ResponseEntity<Object>(userService.register(userInfo), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAuditLog", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuditLog() {
        Object returnObject = userService.getAuditLog();
        System.out.println(returnObject);
        return new ResponseEntity<Object>(returnObject, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAuditLog/{revision}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuditLog(@PathVariable("revision") int revision) {
        Object returnObject = userService.getAuditLog(revision);
        System.out.println(returnObject);
        return new ResponseEntity<Object>(returnObject, HttpStatus.OK);
    }
}

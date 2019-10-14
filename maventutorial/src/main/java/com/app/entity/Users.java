package com.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Audited
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "subscribed")
    private String subscribed;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private UserInfo userInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_room",
            joinColumns = @JoinColumn(name = "userEmail"),
            inverseJoinColumns = @JoinColumn(name = "roomID"))
    private List<Rooms> roomList = new ArrayList<>();

    public Users(String email, String password, String subscribed) {
        this.email = email;
        this.password = password;
        this.subscribed = subscribed;
    }

    public Users(){}
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Rooms> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Rooms> roomList) {
        this.roomList = roomList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String Subscribed) {
        this.subscribed = Subscribed;
    }

}

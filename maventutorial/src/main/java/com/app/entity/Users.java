package com.app.entity;


import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_room",
            joinColumns = @JoinColumn(name = "userEmail"),
            inverseJoinColumns = @JoinColumn(name = "roomID"))
    private List<Rooms> roomList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_email"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Users(String email, String password, String subscribed) {
        this.email = email;
        this.password = password;
        this.subscribed = subscribed;
    }

    public Users() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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

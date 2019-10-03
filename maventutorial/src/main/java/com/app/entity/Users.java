package com.app.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "subscribed")
    private String subscribed;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_room",
            joinColumns = @JoinColumn(name = "userEmail"),
            inverseJoinColumns = @JoinColumn(name = "roomID"))
    private List<Rooms> roomList = new ArrayList<>();

    public List<Rooms> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Rooms> roomList) {
        this.roomList = roomList;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getEmail() {
        return password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int Age) {
        this.age = Age;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(String Subscribed) {
        this.subscribed = Subscribed;
    }

}

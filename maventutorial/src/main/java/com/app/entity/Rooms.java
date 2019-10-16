package com.app.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Audited
@Table(name = "rooms")
public class Rooms {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "floor")
    private int floor;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roomList", cascade = CascadeType.ALL)
    private List<Users> userList = new ArrayList<>();

    public Rooms() {
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}

package com.app.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Table(name = "user_room")
public class User_Room {
    @Id
    @Column(name = "roomID")
    private int roomID;

    @Column(name = "userEmail")
    private String userEmail;

    public User_Room(){}
    public User_Room(int roomID, String userEmail){
        this.roomID = roomID;
        this.userEmail = userEmail;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


}

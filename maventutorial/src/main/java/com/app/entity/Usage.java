package com.app.entity;

import javax.persistence.*;

@Embeddable
@Table(name = "usage")
public class Usage {
    @Id
    @Column(name = "roomID")
    private int roomID;

    @Column(name = "userEmail")
    private String userEmail;

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

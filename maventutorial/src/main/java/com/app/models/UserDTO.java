package com.app.models;

public class UserDTO {
    private String email;
    private String password;
    private String name;
    private int age;
    private String subscribed;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getSubscribed() {
        return subscribed;
    }
}

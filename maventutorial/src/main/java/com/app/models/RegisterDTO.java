package com.app.models;

public class RegisterDTO {
    private String email;
    private String password;
    private String name;
    private String country;
    private int age;
    private String subscribed;
    private String sdt;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getSdt() {
        return sdt;
    }
}

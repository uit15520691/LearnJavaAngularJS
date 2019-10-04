package com.app.entity;

import javax.persistence.*;

@Table(name = "userinfo")
@Entity
public class UserInfo {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "age")
    Integer age;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Users user;


    public UserInfo(){}
    public UserInfo(String email, String name,String country,String sdt,Integer age)
    {

        this.email= email;

        this.name=name;

        this.country=country;

        this.sdt= sdt;

        this.age=age;
    }


    public void setUser(Users user) {
        this.user = user;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Users getUser() {
        return user;
    }

    public String getSdt() {
        return sdt;
    }

    public String getCountry() {
        return country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

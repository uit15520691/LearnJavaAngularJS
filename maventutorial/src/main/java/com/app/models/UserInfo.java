package com.app.models;


public class UserInfo {
    private int ID;
    private String Name;
    private String Password;
    private String Email;
    private int Age;
    private double Salary;

    public UserInfo() {
    }

    public UserInfo(int ID, String Name, String Password, String Email, int Age, double Salary) {
        this.ID = ID;
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Age = Age;
        this.Salary = Salary;
    }

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String toString() {
        return "User [id=" + ID + ", name=" + Name + ", age=" + Age
                + ", salary=" + Salary + "]";
    }
}

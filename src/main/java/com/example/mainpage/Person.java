package com.example.mainpage;

public abstract class  Person {

    protected int id = 0;
    protected String user_name;
    protected String Password;
    protected String gender;
    protected String address;
    protected String phone_number;
    protected String email;

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {return address;}

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract int generate_id();

}

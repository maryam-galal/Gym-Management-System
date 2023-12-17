package com.example.mainpage;

import java.util.ArrayList;

public class Gym {
    private final String name;
    private final String address;
    private final String phoneNumber ;
    public Gym() {
        name = "Fitness Gym";
        address = "Cairo,Nasr city, Makram Ebeid";
        phoneNumber = "01148272855";
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}

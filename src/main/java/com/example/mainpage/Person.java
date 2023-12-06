package com.example.mainpage;
import java.io.*;
import java.util.Scanner;

public abstract class  Person {

    protected int id = 0;
    protected String name;
    protected String Password;
    protected String gender;
    protected String address;
    protected String phone_number;
    protected String email;

    public abstract int generate_id();

}

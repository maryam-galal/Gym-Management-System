package PACKK;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class  Person {

    //protected or private id
    public static int id;

    public String name;

    private String Password;
    public String gender;
    protected String address;
    protected String phone_number;

    protected String email;

    Scanner enter = new Scanner(System.in);
    public Person() {

    }

//function search and not abstract


    public void setPassword(String password) {
        this.Password = password;
    }
    public static void IncrementId(){

    }
}

package PACKK;

import java.io.*;
import java.util.*;

public class Customer extends Person {
    protected static int customer_id=0;
    public Customer() throws IOException {

        id++;
    }
    FileWriter fw = new FileWriter("Customer.txt", true);
    PrintWriter pw = new PrintWriter(fw, true);
    Scanner enter = new Scanner(System.in);


    //handle spaces ALERTTT
    //validationsss
    public PrintWriter getpw() {
        pw.print(id + ",");


        System.out.println("Enter your Name: ");
        name = enter.next();
        pw.print(name + ",");

        System.out.println("Enter the Password: ");
        String Pass=enter.next();
        super.setPassword(Pass);
        pw.print(Pass+ ",");

        System.out.println("Enter gender: ");
        gender = enter.next();
        pw.print(gender + ",");

        System.out.println("Enter your address: ");
        address = enter.next();
        pw.print(address + ",");

        System.out.println("Enter your phone number: ");
        phone_number = enter.next();
        pw.print(phone_number + ",");

        System.out.println("Enter your email: ");
        email = enter.next();
        pw.println(email);

        pw.flush();
        pw.close();
        return pw;
    }


}

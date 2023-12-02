package PACKK;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Coach extends Person{
    int WorkingHours;

    FileWriter fw = new FileWriter("Coach.txt", true);
    PrintWriter pw = new PrintWriter(fw, true);
    Scanner enter = new Scanner(System.in);

    public Coach() throws IOException {
        ++id;
    }


    //handle spaces ALERTTT
    //validationsss
    public PrintWriter getpw() {
        // ++id;
        pw.print(id + ",");

        System.out.println("Enter your Name: ");
        name = enter.next();
        pw.print(name + ",");

        System.out.println("Enter the Password: ");
        String Pass=enter.next();
        super.setPassword(Pass);
        pw.print(Pass + ",");

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
        pw.print(email + ",");

        System.out.println("Enter your WorkingHours: ");//working hours table
        WorkingHours= enter.nextInt();
        while(WorkingHours > 10){
            System.out.println("The maximum number of WorkingHours is 10 \n Please enter the WorkingHours again: ");
            WorkingHours= enter.nextInt();
        }
        pw.println(WorkingHours);

        pw.flush();
        pw.close();
        return pw;
    }

    public void  displayCoachInfo(){
        System.out.println("Coach Name:"+name);
        System.out.println("Coach Phone number:"+phone_number);
        System.out.println("Coach WorkingHours:"+WorkingHours);
    }
}

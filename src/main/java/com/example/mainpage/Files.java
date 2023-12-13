package com.example.mainpage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public static void Load_ArrayList (String FileName ){
        //reading file info
        try (Scanner fileScanner = new Scanner(new File(FileName))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
               MainApplication.userList.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void LoadCustomer(ArrayList<String []> user_list) {
    //saving data into lists
        Customer customer = new Customer();
    for (String[] data : user_list) {
        if (data.length >= 8) {
            String userType = data[7].trim();
            if (userType.equals("customer")) {
                customer.setId(data[0].trim());
                customer.setUser_name(data[1].trim());
                customer.setPassword(data[2].trim());
                customer.setPhone_number(data[3].trim());
                customer.setEmail(data[4].trim());
                customer.setAddress(data[5].trim());
                customer.setGender(data[6].trim());
                MainApplication.customerArrayList.add(customer);
            }
        }

    }
}
    public static void  LoadCoach(ArrayList<String[]> user_list){
        Coach coach = new Coach();
    for (String[] data : user_list) {
        if (data.length >= 8) {
            String userType = data[7].trim();
            if(userType.equals("coach")) {
                   coach.setId(data[0].trim());
                   coach.setUser_name(data[0].trim());
                   coach.setPassword(data[1].trim());
                   coach.setPhone_number(data[2].trim());
                   coach.setEmail(data[3].trim());
                   coach.setAddress(data[4].trim());
                   coach.setGender(data[5].trim());
                   MainApplication.coachArrayList.add(coach);
            }
        }

    }
    }
    public static void  LoadInBody (ArrayList<String []> InBody_membership_list){
        InBody i = new InBody();
        for (String [] data : InBody_membership_list) {
            if (data.length <= 8) {
                Customer.setId(data[0].trim());
                i.setDate_of_InBody(data[1].trim());
                i.setMass(Double.parseDouble(data[2].trim()));
                i.setBody_fat(Double.parseDouble(data[3].trim()));
                i.setHeight(Double.parseDouble(data[4].trim()));
                i.setMinerals_var(Double.parseDouble(data[5].trim()));
                i.setProtein_var(Double.parseDouble(data[6].trim()));
                i.setTotal_weight(Double.parseDouble(data[7].trim()));
                i.setWater_weight(Double.parseDouble(data[8].trim()));

                MainApplication.inBodyArrayList.add(i);

            }

        }
        System.out.println("inbody done");
    }

//  pw.println("\"id\",\"User name\",\"Password\",\"Phone Number\",\"Email\",\"Address\",\"Gender\",\"User Type\"");

    public static void WriteInFile(String file_name, String userType) throws IOException {
        FileWriter fw = new FileWriter(file_name, true);
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Appending to file: " + file_name);

        if (file_name.equals("Registration.csv")) {
            // Write the last added coach
            if (!MainApplication.coachArrayList.isEmpty() && userType.equals("coach")) {
                Coach lastCoach = MainApplication.coachArrayList.get(MainApplication.coachArrayList.size() - 1);
                pw.println(lastCoach.getId() + "," + lastCoach.getUser_name() + "," + lastCoach.getPassword() + "," +
                        lastCoach.getPhone_number() + "," + lastCoach.getEmail() + "," + lastCoach.getAddress() + "," +
                        lastCoach.getGender() + "," + "coach");
                System.out.println("Appending Coach: " + lastCoach.getId() + " " + lastCoach.getUser_name());
            }

            // Write the last added customer
            if (!MainApplication.customerArrayList.isEmpty() && userType.equals("customer")) {
                Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);
                pw.println(lastCustomer.getId() + "," + lastCustomer.getUser_name() + "," + lastCustomer.getPassword() + "," +
                        lastCustomer.getPhone_number() + "," + lastCustomer.getEmail() + "," + lastCustomer.getAddress() + "," +
                        lastCustomer.getGender() + "," + "customer");
                System.out.println("Appending Customer: " + lastCustomer.getId() + " " + lastCustomer.getUser_name());
            }
        }

        // Close the PrintWriter and FileWriter
        pw.close();
        fw.close();
    }


}

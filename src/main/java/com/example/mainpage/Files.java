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
    for (String[] data : user_list) {
        if (data.length >= 7) {
            String userType = data[6].trim();
            if(userType.equals("coach")) {
                Coach coach = new Coach();
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


     public static void WriteInFile (String file_name) throws IOException {
    FileWriter fw = new FileWriter(file_name, true);
    PrintWriter pw = new PrintWriter(fw, false);

    if (file_name.equals("Registration.csv")){
    pw.println("\"id\",\"User name\",\"Password\",\"Phone Number\",\"Email\",\"Address\",\"Gender\"");
        for (Coach c : MainApplication.coachArrayList) {
            pw.println(c.getId() +","+c.getUser_name() +","+ c.getPassword() +","+ c.getPhone_number() + ","+ c.getEmail() + "," +c.getAddress() + "," + c.getGender() + "," +"coach");
            System.out.println("done Coach");
        }

        for (Customer c : MainApplication.customerArrayList) {
            pw.println(c.getId() +","+c.getUser_name() +","+ c.getPassword() +","+ c.getPhone_number() + ","+ c.getEmail() + "," +c.getAddress() + "," + c.getGender() + "," +"customer");
            System.out.println("done Customer");
        }

    }
    else if (file_name.equals("InBody_Membership.csv")){
        //pw.println("ID,Date_of_InBody, mass,body_fat, height,minerals_var, protein_var, total_weight, water_weight, choice, number_of_months, start_date, days_per_week");
        for (InBody in : MainApplication.inBodyArrayList) {
            pw.print(Customer.id+ ","+ in.Date_of_InBody + "," + in.mass + "," + in.body_fat + "," + in.height + "," + in.minerals_var + "," + in.protein_var + "," + in.total_weight + "," + in.water_weight + ",");
            System.out.println("inbody done");
        }
    }
         pw.close();
}
}

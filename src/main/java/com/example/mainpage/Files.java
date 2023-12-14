package com.example.mainpage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Files {

    public static void Load_ArrayList(String FileName) {
        //reading file info
        try (Scanner fileScanner = new Scanner(new File(FileName))) {
            if(FileName.equals("Registration.csv")) {
                while (fileScanner.hasNextLine()) {
                    String[] data = fileScanner.nextLine().split(",");
                    MainApplication.userList.add(data);
                }
            }
            else if(FileName.equals("Subscription.csv")){
                while (fileScanner.hasNextLine()) {
                    String[] data = fileScanner.nextLine().split(",");
                    MainApplication.inBodyArrayListFromFile.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void LoadCoach(ArrayList<String[]> user_list) {
        for (String[] data : user_list) {
            String userType = data[7].trim();
            System.out.println(userType);
            System.out.println(userType);
            if (data.length >= 8) {
                if (userType.equals("coach")) {
                    Coach coach = new Coach();
                    coach.setId(data[0].trim());
                    coach.setUser_name(data[1].trim());
                    coach.setPassword(data[2].trim());
                    coach.setPhone_number(data[3].trim());
                    coach.setEmail(data[4].trim());
                    coach.setAddress(data[5].trim());
                    coach.setGender(data[6].trim());
                    MainApplication.coachArrayList.add(coach);
                }
                 else if (userType.equals("customer")) {
                    Customer customer = new Customer();
                    customer.setId(data[0].trim());
                    customer.setUser_name(data[1].trim());
                    customer.setPassword(data[2].trim());
                    customer.setPhone_number(data[3].trim());
                    customer.setEmail(data[4].trim());
                    customer.setAddress(data[5].trim());
                    customer.setGender(data[6].trim());
                    Subscription.customer_id=customer.getId();
                    MainApplication.customerArrayList.add(customer);
                }
            }
        }
    }
    public static void Load_InBody_MembershipPlan() {
        InBody i = new InBody();
        Membership_Plan p = new Membership_Plan();
        for (String[] d : MainApplication.inBodyArrayListFromFile) {
            if (d.length <= 8) {
                Customer.setId(d[0].trim());
                i.setDate_of_InBody(d[1].trim());
                i.setMass(Double.parseDouble(d[2].trim()));
                i.setBody_fat(Double.parseDouble(d[3].trim()));
                i.setHeight(Double.parseDouble(d[4].trim()));
                i.setMinerals_var(Double.parseDouble(d[5].trim()));
                i.setProtein_var(Double.parseDouble(d[6].trim()));
                i.setTotal_weight(Double.parseDouble(d[7].trim()));
                i.setWater_weight(Double.parseDouble(d[8].trim()));
                MainApplication.InBodyList.add(i);
            } else {
                p.setChoice(d[9].trim());
                p.setStart_date(d[10].trim());
                p.setNumber_of_months(Integer.parseInt(d[11].trim()));
                p.setDays_per_week(Integer.parseInt(d[12].trim()));
                p.setPlan_price(Double.parseDouble(d[13].trim()));

                MainApplication.membershipPlanArrayList.add(p);
            }
        }
    }


    public static void WriteInFile(String file_name, String userType) throws IOException {
        FileWriter fw = new FileWriter(file_name, true);
        PrintWriter pw = new PrintWriter(fw);

        if (file_name.equals("Registration.csv")) {
            //pw.println("\"ID\",\"User name\",\"Password\",\"Phone Number\",\"Email\",\"Address\",\"Gender\",\"User Type\"");
            // Write the last added coach
            if (!MainApplication.coachArrayList.isEmpty() && userType.equals("coach")) {
                Coach lastCoach = MainApplication.coachArrayList.get(MainApplication.coachArrayList.size() - 1);
                pw.println(lastCoach.getId() + "," + lastCoach.getUser_name() + "," + lastCoach.getPassword() + "," +
                        lastCoach.getPhone_number() + "," + lastCoach.getEmail() + "," + lastCoach.getAddress() + "," +
                        lastCoach.getGender() + "," + "coach");
                System.out.println("Appending Coach: " + lastCoach.getId() + " " + lastCoach.getUser_name());
            }

            // Write the last added customer
            else if (!MainApplication.customerArrayList.isEmpty() && userType.equals("customer")) {
                Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);
                pw.println(lastCustomer.getId() + "," + lastCustomer.getUser_name() + "," + lastCustomer.getPassword() + "," +
                        lastCustomer.getPhone_number() + "," + lastCustomer.getEmail() + "," + lastCustomer.getAddress() + "," +
                        lastCustomer.getGender() + "," + "customer");
                System.out.println("Appending Customer: " + lastCustomer.getId() + " " + lastCustomer.getUser_name());
            }
        } else if (file_name.equals("InBody.csv")) {
            //pw.println("\"ID\", \"Date of InBody\",\"Mass, Body Fat\",\"Height\",\"Minerals\",\"Protein\",\"Total Weight\",\"Water Weight\"");
            for (InBody in : MainApplication.InBodyList) {
                pw.println(Customer.id + "," + in.Date_of_InBody + "," + in.mass + "," + in.body_fat + "," + in.height + "," + in.minerals_var + "," + in.protein_var + "," + in.total_weight + "," + in.water_weight + ",");
                System.out.println("inbody done");
            }
        } else if (file_name.equals("Subscription.csv")) {
            Customer c = new Customer();
            //pw.println("\"Customer ID\",\"Coach ID\",\"Plan Choice\",\"Start Date\",\"Number of Months\",\"Days Per Week\",\"Plan Price\"\"");
            for (Membership_Plan p : MainApplication.membershipPlanArrayList) {
                Subscription s = new Subscription(p);
                pw.println(Subscription.getCustomer_id() + "," + Subscription.getCoach_id() + "," + p.choice + "," + p.start_date + "," + p.number_of_months + "," + p.days_per_week + "," + p.plan_price);
                System.out.println("plan done");
            }
        }

        pw.close();
        fw.close();
    }
}
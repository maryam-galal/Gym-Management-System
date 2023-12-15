package com.example.mainpage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Files {

    public static void Load_ArrayList(String FileName) {
        //reading file info
        try (Scanner fileScanner = new Scanner(new File(FileName))) {
            if (fileScanner.hasNextLine()) {
                // Skip the header line
                fileScanner.nextLine();

                if (FileName.equals("Registration.csv")) {
                    while (fileScanner.hasNextLine()) {
                        String[] data = fileScanner.nextLine().split(",");
                        MainApplication.userList.add(data);
                    }
                } else if (FileName.equals("Subscription.csv")) {
                    while (fileScanner.hasNextLine()) {
                        String[] data = fileScanner.nextLine().split(",");
                        MainApplication.Subscription_Data.add(data);
                    }
                } else if (FileName.equals("InBody.csv")) {
                    while (fileScanner.hasNextLine()) {
                        String[] data = fileScanner.nextLine().split(",");
                        MainApplication.InBody_Data.add(data);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void Load_coach_customer() {
        for (String[] data : MainApplication.userList) {
            if (data.length >= 8 ) {
                String userType = data[7].trim();

                if (userType.equals("customer")) {
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
               else if (userType.equals("coach")) {
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
            }
        }
    }
    public static void Load_InBody() {
        for (String[] d : MainApplication.InBody_Data) {
            if (d.length == 9) {
                InBody i = new InBody();
                Customer c = new Customer();
                c.setId(d[0].trim());
                i.setDate_of_InBody(d[1].trim());
                i.setMass(Double.parseDouble(d[2].trim()));
                i.setBody_fat(Double.parseDouble(d[3].trim()));
                i.setHeight(Double.parseDouble(d[4].trim()));
                i.setMinerals_var(Double.parseDouble(d[5].trim()));
                i.setProtein_var(Double.parseDouble(d[6].trim()));
                i.setTotal_weight(Double.parseDouble(d[7].trim()));
                i.setWater_weight(Double.parseDouble(d[8].trim()));
                MainApplication.InBodyList.add(i);
            }
        }
    }
    public static void Load_Subscription() {
        for (String[] S : MainApplication.Subscription_Data) {
            if (S.length == 8) {
                Membership_Plan p = new Membership_Plan();
                p.setChoice(S[3].trim());
                p.setStart_date(S[4].trim());
                p.setNumber_of_months(Integer.parseInt(S[5].trim()));
                p.setDays_per_week(Integer.parseInt(S[6].trim()));
                p.setPlan_price(Double.parseDouble(S[7].trim()));

                MainApplication.membershipPlanArrayList.add(p);
            }
        }
    }



    public static void WriteInFile(String file_name, String userType) throws IOException {
        FileWriter fw = new FileWriter(file_name, true);
        PrintWriter pw = new PrintWriter(fw);

        Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);

        if (file_name.equals("Registration.csv")) {
            //pw.println("\"ID\",\"User name\",\"Password\",\"Phone Number\",\"Email\",\"Address\",\"Gender\",\"User Type\",\"Starting Hour\",\"Ending Hour\"");
            // Write the last added coach
            if (!MainApplication.coachArrayList.isEmpty() && userType.equals("coach")) {
                Coach lastCoach = MainApplication.coachArrayList.get(MainApplication.coachArrayList.size() - 1);
                pw.println(lastCoach.getId() + "," + lastCoach.getUser_name() + "," + lastCoach.getPassword() + "," +
                        lastCoach.getPhone_number() + "," + lastCoach.getEmail() + "," + lastCoach.getAddress() + "," +
                        lastCoach.getGender() + "," + "coach"+","+lastCoach.getStartinghour()+","+lastCoach.getEndinghour());

                System.out.println("Appending Coach: " + lastCoach.getId() + " " + lastCoach.getUser_name());
            }

            // Write the last added customer

            else if (!MainApplication.customerArrayList.isEmpty() && userType.equals("customer")) {
                pw.println(lastCustomer.getId() + "," + lastCustomer.getUser_name() + "," + lastCustomer.getPassword() + "," +
                        lastCustomer.getPhone_number() + "," + lastCustomer.getEmail() + "," + lastCustomer.getAddress() + "," +
                        lastCustomer.getGender() + "," + "customer"+","+""+",");

                System.out.println("Appending Customer: " + lastCustomer.getId() + " " + lastCustomer.getUser_name());
            }
        }

        else if (file_name.equals("InBody.csv")) {
            //pw.println("\"ID\", \"Date of InBody\",\"Mass, Body Fat\",\"Height\",\"Minerals\",\"Protein\",\"Total Weight\",\"Water Weight\"");
            if (!MainApplication.InBodyList.isEmpty()) {
                InBody in = MainApplication.InBodyList.get(MainApplication.InBodyList.size() - 1);
                pw.println( Subscription.getCustomer_id()+ "," + in.Date_of_InBody + "," + in.mass + "," + in.body_fat + "," + in.height + "," + in.minerals_var + "," + in.protein_var + "," + in.total_weight + "," + in.water_weight);
                System.out.println("inbody done");
            }
        }

        else if (file_name.equals("Subscription.csv")) {
            //pw.println("\"Customer ID\",\"Coach ID\",\"Customer Name\",\"Plan Choice\",\"Start Date\",\"Number of Months\",\"Days Per Week\",\"Plan Price\"\"");
            if (!MainApplication.membershipPlanArrayList.isEmpty()) {
                Membership_Plan p = MainApplication.membershipPlanArrayList.get(MainApplication.membershipPlanArrayList.size() - 1);
                pw.println(Subscription.getCustomer_id() + "," + Subscription.getCoach_id() + "," +lastCustomer.user_name+","+ p.choice + "," + p.start_date + "," + p.number_of_months + "," + p.days_per_week + "," + p.plan_price);
                System.out.println("plan done");
            }
        }

        pw.close();
        fw.close();
    }
}
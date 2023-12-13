package com.example.mainpage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public static void Load_ArrayList(String FileName) {
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

    public static void LoadCustomer(ArrayList<String[]> user_list) {
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

    public static void LoadCoach(ArrayList<String[]> user_list) {
        Coach coach = new Coach();
        for (String[] data : user_list) {
            if (data.length >= 8) {
                String userType = data[7].trim();
                if (userType.equals("coach")) {
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

    public static void Load_InBody_MembershipPlan(ArrayList<String[]> InBody_membership_list) {
        InBody i = new InBody();
        Membership_Plan p = new Membership_Plan();
        for (String[] data : InBody_membership_list) {
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
            else {
                p.setChoice(data[9].trim());
                p.setStart_date(data[10].trim());
                p.setNumber_of_months(Integer.parseInt(data[11].trim()));
                p.setDays_per_week(Integer.parseInt(data[12].trim()));
                p.setPlan_price(Double.parseDouble(data[13].trim()));

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
                        lastCoach.getGender()  +","+ "coach");
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

        else if (file_name.equals("InBody_Membership.csv")) {
            //pw.println("\"ID\", \"Date of InBody\",\"Mass, Body Fat\",\"Height\",\"Minerals\",\"Protein\",\"Total Weight\",\"Water Weight\"");
            for (InBody in : MainApplication.inBodyArrayList) {
                pw.println(Customer.id + "," + in.Date_of_InBody + "," + in.mass + "," + in.body_fat + "," + in.height + "," + in.minerals_var + "," + in.protein_var + "," + in.total_weight + "," + in.water_weight + ",");
                System.out.println("inbody done");
            }
        }
        else if (file_name.equals("Subscription.csv")){
            //pw.println("\"Customer ID\",\"Coach ID\",\"Plan Choice\",\"Start Date\",\"Number of Months\",\"Days Per Week\",\"Plan Price\"\"");

            for (Coach coach : MainApplication.coachArrayList) {
                int assignedCustomers = 0;
                for (Customer customer : MainApplication.customerArrayList) {
                    if (Subscription.AssignedCoachID == null) {
                        if (assignedCustomers < 10) {
                            coach.addCustomer(customer,coach);
                            assignedCustomers++;
                        } else {
                            break;
                        }
                    }
                }
            }

                for (Membership_Plan p : MainApplication.membershipPlanArrayList) {
                    Subscription s = new Subscription(Customer.id,p);
                pw.println(s.getCustomerID() + "," + s.getAssignedCoachID()+ "," + p.choice + "," + p.start_date + "," + p.number_of_months + "," + p.days_per_week + "," + p.plan_price);
                System.out.println("plan done");
            }
        }

        pw.close();
        fw.close();
    }
}






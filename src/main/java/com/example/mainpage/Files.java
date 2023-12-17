package com.example.mainpage;

import java.io.*;
import java.util.Scanner;

public class Files {

    public static void load_Equipment(String FileName){
        try (Scanner fileScanner = new Scanner(new File(FileName))) {
            if (fileScanner.hasNextLine()) {
                // Skip the header line
                fileScanner.nextLine();
                    while (fileScanner.hasNextLine()) {
                        String[] data = fileScanner.nextLine().split(",");
                        MainApplication.EquipmentsFromFile.add(data);
                    }
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void load_cardio_strength(){
        for (String[]data:MainApplication.EquipmentsFromFile){
           //if (data.length >= 4 ){
            if(data[3].trim().equals("cardio")){
                CardioEquipment c=new CardioEquipment(data[0].trim(),data[1].trim(),Integer.parseInt(data[2].trim()));
                c.setEntryDate(data[4].trim());
                MainApplication.cardioEquipments.add(c);
            } else if(data[3].trim().equals("strength")) {
                StrengthEquipment t=new StrengthEquipment(data[0].trim(),data[1].trim(),Integer.parseInt(data[2].trim()));
                MainApplication.strengthEquipments.add(t);

            }
           }
       //}
    }
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
                    //Subscription.setCustomer_id(customer.getId());
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
                    coach.setStartinghour(Integer.parseInt(data[8].trim()));
                    coach.setEndinghour(Integer.parseInt(data[9].trim()));
                    MainApplication.coachArrayList.add(coach);
/*                    System.out.println("Starting hour: " + coach.getStartinghour());
                    System.out.println("Ending hour: " + coach.getEndinghour());*/

                }
            }
        }
    }
    public static void Load_InBody() {
        for (String[] d : MainApplication.InBody_Data) {
            if (d.length == 9) {
                InBody i = new InBody();
                i.setCustomer_id(d[0].trim());
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
                Subscription s = new Subscription();
                s.plan = new Membership_Plan();
                s.setCustomer_id(S[0].trim());
                s.setCoach_id(S[1].trim());
                s.setCustomer_name(S[2].trim());
                s.plan.setChoice(S[3].trim());
                s.plan.setStart_date(S[4].trim());
                s.plan.setNumber_of_months(Integer.parseInt(S[5].trim()));
                s.plan.setDays_per_week(Integer.parseInt(S[6].trim()));
                s.plan.setPlan_price(Double.parseDouble(S[7].trim()));
                MainApplication.subscriptionArrayList.add(s);
            }
        }
    }


    public static void updateFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false))) {
            if(fileName.equals("gym_equipment.csv")) {
                // Write the header
                writer.write("Name,Code,Quantity,Equipment Type,Entry date\n");
                // Write data from CardioEquipment list
                for (CardioEquipment cardio : MainApplication.cardioEquipments) {
                    writer.write(String.format("%s,%s,%d,%s,%s\n",
                            cardio.getEquipmentName(), cardio.getEquipmentCode(),
                            cardio.getEquipmentQuantity(), cardio.getEquipmentType(),
                            cardio.getEntryDate()));
                }
                // Write data from StrengthEquipment list
                for (StrengthEquipment strength : MainApplication.strengthEquipments) {
                    writer.write(String.format("%s,%s,%d,%s\n",
                            strength.getEquipmentName(), strength.getEquipmentCode(),
                            strength.getEquipmentQuantity(), strength.getEquipmentType()));
                }
            }

            else if (fileName.equals("Registration.csv")) {
                writer.write("\"ID\",\"User name\",\"Password\",\"Phone Number\",\"Email\",\"Address\",\"Gender\",\"User Type\",\"Starting Hour\",\"Ending Hour\"\n");
                for (Coach c : MainApplication.coachArrayList) {
                    writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%d,%d\n",
                            c.getId() , c.getUser_name() , c.getPassword() ,
                                    c.getPhone_number() , c.getEmail() , c.getAddress() ,
                                    c.getGender() , "coach", c.getStartinghour(), c.getEndinghour()));
                }
                for (Customer c: MainApplication.customerArrayList) {
                    writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,,\n",
                            c.getId() , c.getUser_name() , c.getPassword() ,
                            c.getPhone_number() , c.getEmail() , c.getAddress() ,
                            c.getGender() , "customer"));
                }
            }

            else if (fileName.equals("InBody.csv")) {
                writer.write("\"ID\", \"Date of InBody\",\"Mass\", \"Body Fat\",\"Height\",\"Minerals\",\"Protein\",\"Total Weight\",\"Water Weight\"\n");
                for (InBody in: MainApplication.InBodyList) {
                    writer.write(String.format("%s,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f\n",
                            in.getCustomer_id(), in.Date_of_InBody , in.mass , in.body_fat , in.height ,in.minerals_var , in.protein_var , in.total_weight , in.water_weight));
                }
            }

            else if (fileName.equals("Subscription.csv")) {
                writer.write("\"Customer ID\",\"Coach ID\",\"Customer Name\",\"Plan Choice\",\"Start Date\",\"Number of Months\",\"Days Per Week\",\"Plan Price\"\n");
                for (Subscription s: MainApplication.subscriptionArrayList) {
                    writer.write(String.format("%s,%s,%s,%s,%s,%d,%d,%.2f\n",
                            s.getCustomer_id() , s.getCoach_id(),s.getCustomer_name() , s.plan.choice , s.plan.start_date , s.plan.number_of_months , s.plan.days_per_week , s.plan.plan_price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
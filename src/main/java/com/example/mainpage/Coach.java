package com.example.mainpage;

import java.util.ArrayList;

public class Coach extends Person {
    protected static ArrayList<AssignedCustomersToCoach> supscripedCustomers = new ArrayList<>();// updated by kenzy
    protected static String recievedName= new String();// updated by kenzy

    protected static ArrayList<Customer> customerInformationList= new ArrayList<>();// updated by kenzy
    protected static ArrayList<InBody> customerInBodyList = new ArrayList<>();// updated by kenzy
    private int working_hours;
    private int Startinghour;
    private int Endinghour;
    private static final int MAX_CUSTOMERS = 10;

    protected int numberOfCustomers = 0;

    public void setWorking_hours(int working_hours) {
        this.working_hours = working_hours;
    }
    public int getWorking_hours(){
        return working_hours;
}

    public int getStartinghour() {
        return Startinghour;
    }

    public void setStartinghour(int startinghour) {
        Startinghour = startinghour;
    }

    public int getEndinghour() {
        return Endinghour;
    }

    public void setEndinghour(int endinghour) {
        Endinghour = endinghour;
    }

    private static int coachCounter = 0;
       public Coach() {
           if (MainApplication.coachArrayList.size() > 0) {
               // Increment the counter based on the size of the ArrayList
               coachCounter = MainApplication.coachArrayList.size() + 1;
           } else {
               // Initialize the counter to 1 if the ArrayList is empty
               coachCounter = 1;
           }

           // Construct the unique ID
           id = "A1" + coachCounter;
       }

    public boolean canAcceptCustomer() {
        if((numberOfCustomers < MAX_CUSTOMERS) && (working_hours < 10)) {
            working_hours++;
            numberOfCustomers++;
            return true;
        }
        else{
            return false;
        }
    }
    // updated by kenzy
    public static String SearchforName(String name) {
        // Use the 'name' received from LoginController here
        System.out.println("Received name in the coach class is: " + name);
        String coachId = new String();
        for(Coach coachSearch: MainApplication.coachArrayList){
            if (coachSearch.getUser_name().equals(name)) {
                recievedName= name;
                System.out.println("Received name in if condition is: " + recievedName);
                coachId = coachSearch.getId(); // Assuming 'getId()' returns the ID of the coach
                System.out.println("The id of this coach is: " + coachId);
               break;
            }
        }

        return coachId;
    }
public static ArrayList<AssignedCustomersToCoach> getSubscripedCustomers(){
// this a fubction to retreive the customer name and the customer id Assigned to a specific coach
    String Coachid = Coach.SearchforName(recievedName);
    for (String[] str : MainApplication.Subscription_Data) {
        if(str[1].equals(Coachid)){
            AssignedCustomersToCoach acc= new AssignedCustomersToCoach(str[0],str[2]);
            System.out.println(acc.getCustId()+acc.getCustName());
            supscripedCustomers.add(acc);
        }
    }

   /* for ( AssignedCustomersToCoach str: supscripedCustomers){
        System.out.println(str.getCustId());
        System.out.println(str.getCustName());
    }*/
    return supscripedCustomers;
}
public static ArrayList<Customer> SearchforCustomerData(){
           // This method is to retrieve the customer data from the customerArrayList of a specific coach
           for (Customer cust: MainApplication.customerArrayList){
               for (AssignedCustomersToCoach acc: supscripedCustomers){
                   if (cust.getId().equals(acc.getCustId())&& cust.getUser_name().equals(acc.getCustName())){
                       Customer customer= new Customer();
                       customer.setId(cust.getId());
                       customer.setUser_name(cust.getUser_name());
                       customer.setPassword(cust.getPassword());
                       customer.setPhone_number(cust.getPhone_number());
                       customer.setEmail(cust.getEmail());
                       customer.setAddress(cust.getAddress());
                       customer.setGender(cust.getGender());
                       customerInformationList.add(customer);
                   }
               }
           }
           for (Customer customer: customerInformationList){
               System.out.println(customer.getId());
               System.out.println(customer.getUser_name());
               System.out.println(customer.getPassword());
               System.out.println(customer.getPhone_number());
               System.out.println(customer.getEmail());
               System.out.println(customer.getAddress());
               System.out.println(customer.getGender());
           }
           return customerInformationList;
}
public static ArrayList<InBody> SearchforCustomerInbody (){
    for(String [] s:MainApplication.InBody_Data){
         for(AssignedCustomersToCoach acc: supscripedCustomers){
             if(s[0].trim().equals(acc.getCustId())){
                 InBody inBody = new InBody();
                 inBody.setDate_of_InBody(s[1].trim());
                 double ConvertedMass = Double.parseDouble(s[2].trim());
                 inBody.setMass(ConvertedMass);
                 double Convertedfat = Double.parseDouble(s[3].trim());
                 inBody.setBody_fat(Convertedfat);
                 double ConvertedHeight = Double.parseDouble(s[4].trim());
                 inBody.setHeight(ConvertedHeight);
                 double ConvertedMinerals = Double.parseDouble(s[5].trim());
                 inBody.setMinerals_var(ConvertedMinerals);
                 double ConvertedProtein = Double.parseDouble(s[6].trim());
                 inBody.setProtein_var(ConvertedProtein);
                 double ConvertedTotalWeight = Double.parseDouble(s[7].trim());
                 inBody.setTotal_weight(ConvertedTotalWeight);
                 double ConvertedWaterWeight = Double.parseDouble(s[8].trim());
                 inBody.setWater_weight(ConvertedWaterWeight);
                 customerInBodyList.add(inBody);
             }
         }
     }
    for (InBody inBody: customerInBodyList){
        System.out.print(inBody.getDate_of_InBody()+" , "+inBody.getMass()+" , "+inBody.getBody_fat()
                          +" , "+inBody.getHeight()+" , "+inBody.getMinerals_var()+" , "
                          +inBody.getProtein_var()+" , "+inBody.getTotal_weight()+" , "+ inBody.getWater_weight());
        System.out.println("\n");
    }
    return customerInBodyList;
}

    public void setWorking_hours(String working_hours) {
          this.working_hours= Integer.parseInt(working_hours);
    }

    public static String getRecievedName() {
        return recievedName;
    }

}


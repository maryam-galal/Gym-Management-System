package com.example.mainpage;

public class Customer extends Person {
    private static int customerCounter = 0;
    protected static String recievedName= new String();

    public Coach getAssignedCoach() {
        return AssignedCoach;
    }

    public void setAssignedCoach(Coach assignedCoach) {
        AssignedCoach = assignedCoach;
    }

    protected Coach AssignedCoach = new Coach();

    public Customer (){
        //System.out.println(MainApplication.customerArrayList.size());

        if (MainApplication.customerArrayList.size() > 0) {
            // Increment the counter based on the size of the ArrayList
            customerCounter = MainApplication.customerArrayList.size() + 2;
        } else {
            // Initialize the counter to 1 if the ArrayList is empty
            customerCounter = 1;
        }

        // Construct the unique ID
        id = "B2" + customerCounter;
    }
    static String var = new String();
    public static String processName(String name) {
        System.out.println("Received name in the coach class is: " + name);
        String customerId = new String();
        for(Customer customerSearch: MainApplication.customerArrayList){
            if (customerSearch.getUser_name().equals(name)) {
                recievedName= name;
                System.out.println("Received name in if condition is: " + recievedName);
                customerId = customerSearch.getId(); // Assuming 'getId()' returns the ID of the coach
                var = customerId;
                System.out.println("The id of this coach is: " + customerId);
                break;
            }
        }
        return customerId;
    }
    public static String get(){
        return var;
    }

}

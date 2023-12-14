package com.example.mainpage;

public class Coach extends Person {

    private int working_hours;
    private static final int MAX_CUSTOMERS = 10;
    protected int numberOfCustomers = 0;

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
        if(numberOfCustomers < MAX_CUSTOMERS)
           return true;
        else{
            return false;
        }
    }

    public void addCustomer(Customer customer,Coach coach) {
        if (canAcceptCustomer()) {
            customer.setCoach(coach);
            numberOfCustomers++;
            System.out.println("Customer " + customer.getId() + " assigned to Coach " + coach.getId());
        } else {
            System.out.println("Cannot assign customer to coach. Coach " + getId() + " has reached the maximum limit.");
        }
    }


}

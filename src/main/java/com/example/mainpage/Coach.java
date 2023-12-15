package com.example.mainpage;

public class Coach extends Person {

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
}

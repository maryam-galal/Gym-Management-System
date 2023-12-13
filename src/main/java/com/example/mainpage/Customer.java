package com.example.mainpage;

public class Customer extends Person {
    public static int customerCounter = 0;
    public Customer (){
        //System.out.println(MainApplication.customerArrayList.size());

        if (MainApplication.customerArrayList.size() > 0) {
            // Increment the counter based on the size of the ArrayList
            customerCounter = MainApplication.customerArrayList.size() + 1;
        } else {
            // Initialize the counter to 1 if the ArrayList is empty
            customerCounter = 1;
        }

        // Construct the unique ID
        id = "B2" + customerCounter;
    }
}

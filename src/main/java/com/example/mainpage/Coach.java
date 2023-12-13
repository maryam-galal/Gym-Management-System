package com.example.mainpage;

public class Coach extends Person {
    private int working_hours;

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
}

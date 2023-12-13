package com.example.mainpage;

public class Coach extends Person {
    private int working_hours;

    public Coach (){
        System.out.println(MainApplication.userList.size());

        if (MainApplication.userList.size() > 0) {
            for (String[] coach : MainApplication.userList) {
                id = "A1" + MainApplication.userList.indexOf(coach) ;
            }
        }
        else
            id = "A10";
    }
}

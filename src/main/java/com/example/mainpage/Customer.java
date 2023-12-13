package com.example.mainpage;

public class Customer extends Person {
    public Customer (){
        System.out.println(MainApplication.customerArrayList.size());

        if(MainApplication.customerArrayList.size() > 0) {
            for (String[] customer : MainApplication.userList) {
                id = "B2" + MainApplication.userList.indexOf(customer)+1;
            }
        }
        else
            id = "B20";
    }
}

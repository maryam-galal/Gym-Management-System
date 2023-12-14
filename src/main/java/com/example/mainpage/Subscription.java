package com.example.mainpage;

public class Subscription {
    protected static String CustomerID;
    protected static String AssignedCoachID;
    protected Membership_Plan plan;

    public Subscription(Membership_Plan plan) {
        this.plan = plan;
    }


    public  String getCustomerID() {
        return CustomerID;
    }

    public  String getAssignedCoachID() {
        return AssignedCoachID;
    }
}
package com.example.mainpage;

public class Subscription {
    protected static String CustomerID;
    protected static String AssignedCoachID;
    protected Membership_Plan plan;

    public Subscription(String customerID, Membership_Plan plan) {
        CustomerID = customerID;
        this.plan = plan;
        AssignedCoachID = findAssignedCoachID();
    }

    private String findAssignedCoachID() {
        if (Customer.coach != null) {
            System.out.println(Customer.coach.getId());
            return Customer.coach.getId();
        } else {
            return null;
        }
    }

    public  String getCustomerID() {
        return CustomerID;
    }

    public  String getAssignedCoachID() {
        return AssignedCoachID;
    }
}

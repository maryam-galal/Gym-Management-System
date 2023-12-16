package com.example.mainpage;
public class Subscription {


    protected static Customer customer;

    public static void setCustomer_id(String customer_id) {
        Subscription.customer_id = customer_id;
    }
    protected static String customer_id;
    public static void setCoach_id(String coach_id) {
        Subscription.coach_id = coach_id;
    }
    protected static String coach_id;
    protected Membership_Plan plan;
    public static String getCustomer_id() {
        return customer_id;
    }
    public static String getCoach_id() {
        return coach_id;
    }
    public Subscription(Membership_Plan plan) {
        this.plan = plan;
    }

}

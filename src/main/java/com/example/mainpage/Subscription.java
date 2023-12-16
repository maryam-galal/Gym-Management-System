package com.example.mainpage;




public class Subscription {


    protected  String customer_id;
    protected  String coach_id;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    protected String customer_name;
    protected Membership_Plan plan;

    public Subscription(String id) {
    }
    public Subscription() {
    }

    public Subscription(String customer_id, String coach_id) {
        this.customer_id = customer_id;
        this.coach_id = coach_id;
        this.plan = new Membership_Plan();
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public  void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }

    public  String getCustomer_id() {
        return customer_id;
    }
    public  String getCoach_id() {return coach_id;}
}

package com.example.mainpage;
public class Subscription {
    protected static Customer customer;
    protected static String customer_id;
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
    public static void findAvailableCoach() {

        for (String[] C : MainApplication.userList) {
            String userType = C[7].trim();
            if (userType.equals("coach")) {
                coach_id = C[0].trim();
                break;
            }
        }
    }
}

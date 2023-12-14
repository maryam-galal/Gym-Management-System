package com.example.mainpage;
public class Subscription {
    protected static Customer customer;
    protected static String customer_id;

    public static String getCustomer_id() {
        return customer_id;
    }

    public static String getCoach_id() {
        return coach_id;
    }

    protected static String coach_id;

    protected static Coach coach;
    protected Membership_Plan plan;

    public Subscription(Membership_Plan plan) {
        this.plan = plan;
    }
    public static void findAvailableCoach() {
//       System.out.println("called");
//        for(Customer c : MainApplication.customerArrayList){
//            System.out.println(c.getUser_name());
//            System.out.println(c.id);
//            coach_id = c.getId();
//        }
        for (String[] C : MainApplication.userList) {
            String userType = C[7].trim();
            if (C[7].equals("coach")) {
                coach_id = C[0].trim();
            }
        }
    }
}

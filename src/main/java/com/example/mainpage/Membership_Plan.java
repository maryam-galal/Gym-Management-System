package com.example.mainpage;

public class Membership_Plan {

    protected String choice ;
    protected String start_date;
    protected int number_of_months;
    protected int days_per_week;
    public double plan_price;

    public Membership_Plan() {
    }

    public Membership_Plan(String start_date, int number_of_months, int days_per_week) {
        this.start_date = start_date;
        this.number_of_months = number_of_months;
        this.days_per_week = days_per_week;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void calc_price(int base_price, double discount) {
        if (number_of_months >= 3) {
            plan_price = ((((base_price * days_per_week) * 4) * number_of_months) * (1 - discount));
        } else {
            plan_price = ((base_price * days_per_week) * 4) * number_of_months;
        }
    }

    public double choose_plan() {
        if (choice.equals("Silver Plan")) {
            days_per_week = 3; // 3 days per week with base_price = 50 and discount = 20%
            calc_price(50, 0.2);
        } else if (choice.equals("Gold Plan")) {
            days_per_week = 6; // 6 days per week with base_price = 45 and discount = 30%
            calc_price(45, 0.3);
        }
        return plan_price;
    }

}

package com.example.mainpage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.math.BigInteger;

public class Coach extends Person {
    private int Startinghour;
    private int Endinghour;
    protected ArrayList<Customer> customerArrayList = new ArrayList<>();
    protected int numberOfCustomers = 0;
    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }
    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
    public int getStartinghour() {
        return Startinghour;
    }
    public void setStartinghour(int startinghour) {
        Startinghour = startinghour;
    }
    public int getEndinghour() {
        return Endinghour;
    }
    public void setEndinghour(int endinghour) {
        Endinghour = endinghour;
    }
    public Coach() {
           id = generateUniqueID();
       }
  protected String generateUniqueID() {
      UUID uuid = UUID.randomUUID();

      // Convert any Character with number
      BigInteger decimalValue = new BigInteger(uuid.toString().replace("-", ""), 16);
      BigInteger maxLimit = BigInteger.valueOf(999);
      BigInteger limitedValue = decimalValue.mod(maxLimit);
      String limitedDecimalString = limitedValue.toString();
      return "A" + String.format("%03d", Integer.parseInt(limitedDecimalString));

  }
public String assignCoachToCustomer(Customer customer) {
    Collections.shuffle(MainApplication.coachArrayList);
    for (Coach coach : MainApplication.coachArrayList) {
        if(customerArrayList.size() < 11){
            coach.customerArrayList.add(customer);
            customer.setAssignedCoach(coach);
           // Subscription s = new Subscription(customer.getId(),coach.getId());
            System.out.println(customer.getId());
            System.out.println(coach.getId());
            return coach.getId();
        }
    } return null;

}
}

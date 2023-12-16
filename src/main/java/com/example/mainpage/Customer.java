package com.example.mainpage;
import java.math.BigInteger;
import java.util.UUID;
public class Customer extends Person {
    protected static String recievedName= new String();

    public Coach getAssignedCoach() {
        return AssignedCoach;
    }

    public void setAssignedCoach(Coach assignedCoach) {
        AssignedCoach = assignedCoach;
    }

    protected Coach AssignedCoach = new Coach();

    public Customer (){
        id = generateUniqueID();
    }
    protected String generateUniqueID() {
        UUID uuid = UUID.randomUUID();

        // Convert any Character with number
        BigInteger decimalValue = new BigInteger(uuid.toString().replace("-", ""), 16);
        BigInteger maxLimit = BigInteger.valueOf(999);
        BigInteger limitedValue = decimalValue.mod(maxLimit);
        String limitedDecimalString = limitedValue.toString();
        return "B" + String.format("%03d", Integer.parseInt(limitedDecimalString));
    }
    static String var = new String();
    public static String processName(String name) {
        System.out.println("Received name in the coach class is: " + name);
        String customerId = new String();
        for(Customer customerSearch: MainApplication.customerArrayList){
            if (customerSearch.getUser_name().equals(name)) {
                recievedName= name;
                System.out.println("Received name in if condition is: " + recievedName);
                customerId = customerSearch.getId(); // Assuming 'getId()' returns the ID of the coach
                var = customerId;
                System.out.println("The id of this coach is: " + customerId);
                break;
            }
        }
        return customerId;
    }
    public static String get(){
        return var;
    }

}

package com.example.mainpage;

public class AssignedCustomersToCoach {
    private String custId;
    private String custName;

    public AssignedCustomersToCoach(String custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustName() {
        return custName;
    }
}

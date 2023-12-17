package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Name_Controller {
    private static ArrayList<AssignedCustomersToCoach> customerNames= Coach.getSubscripedCustomers();
   private static ArrayList<String> Names= new ArrayList<>();
    MainApplication main = new MainApplication();
    @FXML
    private ChoiceBox<String>ChooseNameCB= new ChoiceBox<>();

public static ArrayList<String> getCustomerNames(){
    Names.clear();
    System.out.println(customerNames.size());
    for (int i=0; i<customerNames.size()/2;i++){
        String name= customerNames.get(i).getCustName();
        System.out.println(customerNames.get(i).getCustName());
        Names.add(name);
    }
    return Names;
}


    public void initialize() {
        System.out.println("Initialize method called");
        ChooseNameCB.getItems().clear();
        ChooseNameCB.getItems().addAll(Name_Controller.getCustomerNames());
    }
}

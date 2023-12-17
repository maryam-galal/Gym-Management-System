package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Name_Controller {

    @FXML
    private Label AddressLabel;
    @FXML
    private Label EmailLabel;

    @FXML
    private Label GenderLabel;

    @FXML
    private Label IDLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label PhoneLabel;

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

    @FXML
    void DisplayCustomerInfo(ActionEvent event) {
        for(Customer c : MainApplication.customerArrayList){
            if(ChooseNameCB.getValue().equals(c.getUser_name())){
                NameLabel.setVisible(true);
               AddressLabel.setVisible(true);
                EmailLabel.setVisible(true);
                IDLabel.setVisible(true);
                PhoneLabel.setVisible(true);
                GenderLabel.setVisible(true);
                NameLabel.setText(c.getUser_name());
                AddressLabel.setText(c.getAddress());
                EmailLabel.setText(c.getEmail());
                IDLabel.setText(c.getId());
                PhoneLabel.setText(c.getPhone_number());
                GenderLabel.setText(c.getGender());
            }
        }
    }
    @FXML
    void GoBack(ActionEvent event) throws IOException {
MainApplication main =new MainApplication();
        main.changeScene("coachPage.fxml");
    }
}

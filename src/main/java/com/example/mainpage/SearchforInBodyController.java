package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class SearchforInBodyController {
    private static ArrayList<String> Names= new ArrayList<>();
    private static ArrayList<AssignedCustomersToCoach> customerNames= Coach.getSubscripedCustomers();
    @FXML
    Label DateOfInBodyLabel= new Label();
    @FXML
    Label MineralsLabel=new Label();
    @FXML
    Label TotalWeightLabel= new Label();
    @FXML
    Label Heightlabel= new Label();
    @FXML
    Label WaterWeightLabel=new Label();
    @FXML
    Label ProteinLabel= new Label();
    @FXML
    Label BodyFatLabel= new Label();
    @FXML
    Label MassLabel= new Label();
    @FXML
    private ChoiceBox<String> InBodyCB= new ChoiceBox<>();
    @FXML
    private TextField name;

    MainApplication main= new MainApplication();
    public ArrayList<String> getCustomerNames(){
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
        InBodyCB.getItems().clear();
        InBodyCB.getItems().addAll(getCustomerNames());
    }

    @FXML
    void DisplayInbody(ActionEvent event) {
        for(Customer c : MainApplication.customerArrayList){
            if(name.getText().equals(c.getUser_name())){
                for(InBody in : MainApplication.InBodyList){
                    DateOfInBodyLabel.setText(in.getDate_of_InBody());
                    TotalWeightLabel.setText(String.valueOf(in.getTotal_weight()));
                    WaterWeightLabel.setText(String.valueOf(in.getWater_weight()));
                    BodyFatLabel.setText(String.valueOf(in.getBody_fat()));
                    MineralsLabel.setText(String.valueOf(in.getMinerals_var()));
                    Heightlabel.setText(String.valueOf(in.getHeight()));
                    ProteinLabel.setText(String.valueOf(in.getProtein_var()));
                    MassLabel.setText(String.valueOf(in.getMass()));
                }

            }
        }
    }

    @FXML
    void GoBack(ActionEvent event) throws IOException {
        main.changeScene("coachPage.fxml");
    }
}

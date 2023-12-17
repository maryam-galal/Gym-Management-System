package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

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

    MainApplication main= new MainApplication();
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
        InBodyCB.getItems().clear();
        InBodyCB.getItems().addAll(Name_Controller.getCustomerNames());
    }
    @FXML
    void GoBack(ActionEvent event) throws IOException {
        main.changeScene("coachPage.fxml");
    }
}

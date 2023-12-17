package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Gender_Controller implements Initializable{
    @FXML
    private ChoiceBox<String> GenderSECB=new ChoiceBox<>();
    MainApplication main = new MainApplication();
    @FXML
    private RadioButton FemaleRB,MaleRB = new RadioButton();

    @FXML
    private TableView<Customer> InformationTable = new TableView<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize_subscribed_customers();}
    private void initialize_subscribed_customers() {
        // Initialize TableColumn properties
        TableColumn<Customer, String> Name = new TableColumn<>("Name");
        TableColumn<Customer, String> ID = new TableColumn<>("ID");
        TableColumn<Customer, String> Phone_Number = new TableColumn<>("Phone Number");
        TableColumn<Customer, String> Address = new TableColumn<>("Address");
        TableColumn<Customer, String> Email = new TableColumn<>("Email");

        Name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Phone_Number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Set properties for other columns
        InformationTable.getColumns().clear(); // Clear existing columns
        InformationTable.getColumns().addAll(Name,ID,Phone_Number,Address,Email );
    }
    public void ReturnGenderInfo(MouseEvent event){
        InformationTable.getItems().clear();
        ArrayList <Customer> returnedCustomers=Coach.SearchforCustomerData();

        for(int i=0;i<returnedCustomers.size()/2;i++){
            if (FemaleRB.isSelected() &&returnedCustomers.get(i).getGender().equals("Female") ){
                InformationTable.getItems().add(returnedCustomers.get(i));

                // for(Customer customer:returnedCustomers) {
                //   InformationTable.getItems().add(customer);
                //}
            }
            else if (MaleRB.isSelected() && returnedCustomers.get(i).getGender().equals("Male")) {
                InformationTable.getItems().add(returnedCustomers.get(i));

                //for (Customer customer : returnedCustomers) {
                //  InformationTable.getItems().add(customer);
                //}
            }
        }
    }
    @FXML
    void GoBack(ActionEvent event) throws IOException {
        main.changeScene("coachPage.fxml");
    }
}

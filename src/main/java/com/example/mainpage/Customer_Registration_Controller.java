package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;
import java.io.*;

public class Customer_Registration_Controller implements Initializable {
    @FXML
    private ChoiceBox <String> Gender;
    String [] Gender_v = {"Male", "Female"};
    ArrayList<Customer> customerArrayList = new ArrayList<>();
    Customer customer = new Customer();
    private TextField mytextfield, pass_text, gender_text, adress_text, phone_text, email_text;

    public Customer_Registration_Controller() throws IOException {
    }
    @FXML
    public void Add_Customer(ActionEvent event) {
        customer.name = mytextfield.getText();
        customer.Password = pass_text.getText();
        customer.gender = gender_text.getText();
        customer.address = adress_text.getText();
        customer.phone_number = phone_text.getText();
        customer.email = email_text.getText();

        customerArrayList.add(customer);
        System.out.printf("Adding customer" + customerArrayList.size() + " is DONE Successfully\n");

        pw.print(mytextfield.getText() + "," +pass_text.getText() + "," +gender_text.getText() + "," +adress_text.getText() + "," +phone_text.getText() + "," + email_text.getText() + "," + "customer\n");

        pw.flush();
        pw.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Gender.getItems().addAll(Gender_v);
    }
    FileWriter fw = new FileWriter("Customer.csv", true);
    PrintWriter pw = new PrintWriter(fw, true);
}

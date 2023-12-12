package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.*;
import java.io.*;

public class Customer_RegistrationForm_Controller {
    @FXML
    private TextField Username, Password, phone_text, email_text, address_text;
    @FXML
    private ChoiceBox<String> genderChoiceBox;

    Customer customer = new Customer();

    @FXML
    public void initialize() {
        genderChoiceBox.getItems().addAll("Male", "Female");
    }

    public void Load_to_Static_list() {
        customer.setUser_name(Username.getText());
        customer.setPassword(Password.getText());
        customer.setPhone_number(phone_text.getText());
        customer.setEmail(email_text.getText());
        customer.setAddress(address_text.getText());
        customer.setGender(genderChoiceBox.getValue());
        MainApplication.customerArrayList.add(customer);
    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        Load_to_Static_list();
        //temp
        Files.WriteInFile("Registration.csv");
        MainApplication RegisterMain = new MainApplication();
        RegisterMain.changeScene("InBody_Membership.fxml");
    }
}

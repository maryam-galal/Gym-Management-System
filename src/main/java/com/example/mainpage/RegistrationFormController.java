package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.*;
import java.io.*;

public class RegistrationFormController {
    @FXML
    private TextField Username, Password, phone_text, email_text, address_text;
    @FXML
    private ChoiceBox<String> genderChoiceBox;

    Customer customer = new Customer();

    @FXML
    public void initialize() {
        genderChoiceBox.getItems().addAll("Male", "Female");
    }

    public ArrayList<Customer> ArrayListCustomer() throws IOException {
        ArrayList<Customer> CustomerList = new ArrayList<>();

        customer.gender = genderChoiceBox.getValue();
        customer.address = address_text.getText();
        customer.email = email_text.getText();
        customer.Password = Password.getText();
        customer.name = Username.getText();
        customer.phone_number = phone_text.getText();
        CustomerList.add(customer);

        return CustomerList;
    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        FileWriter fw = new FileWriter("Registration.csv", true);
        PrintWriter pw = new PrintWriter(fw, false);

        //boolean headersWritten = false;
        /*if (!headersWritten) {
            pw.println("address,name,email,gender,phone_number,Password,user_type");
            headersWritten = true; // Set the flag to true after writing headers
        }*/

        for (Customer c : ArrayListCustomer()) {
            pw.print(c.address + "," + c.name + "," + c.email + "," + c.gender + "," + c.phone_number + "," + c.Password + ","+"customer"+"\n");
        }
        pw.flush();
        pw.close();

        MainApplication RegisterMain = new MainApplication();
        RegisterMain.changeScene("InBody_Membership.fxml");
    }
}

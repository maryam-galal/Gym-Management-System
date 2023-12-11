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

    public ArrayList<Customer> ArrayListCustomer() {
        ArrayList<Customer> CustomerList = new ArrayList<>();

        customer.setUser_name(Username.getText());
        customer.setPassword(Password.getText());
        customer.setPhone_number(phone_text.getText());
        customer.setEmail(email_text.getText());
        customer.setAddress(address_text.getText());
        customer.setGender(genderChoiceBox.getValue());
        CustomerList.add(customer);

        return CustomerList;
    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        FileWriter fw = new FileWriter("Registration.csv", true);
        PrintWriter pw = new PrintWriter(fw, false);

//        boolean headersWritten = false;
//        if (!headersWritten) {
//            pw.println("\"User name\",\"Password\",\"Phone Number\",\"Email\",\"Address\",\"Gender\"");
//            headersWritten = true;
//        }

        for (Customer c : ArrayListCustomer()) {
            pw.println(c.getUser_name() +","+ c.getPassword() +","+ c.getPhone_number() + ","+ c.getEmail() + "," +c.getAddress() + "," + c.getGender() + "," +"customer");
            System.out.println("done");
        }
        pw.flush();
        pw.close();

        MainApplication RegisterMain = new MainApplication();
        RegisterMain.changeScene("InBody_Membership.fxml");
    }
}

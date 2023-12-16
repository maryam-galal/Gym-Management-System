package com.example.mainpage;
import com.example.mainpage.exceptions.signupExceptions.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import java.io.*;

public class Customer_RegistrationForm_Controller {
    @FXML
    private TextField Username, Password, phone_text, email_text, address_text;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private Label usernameError;
    @FXML
    private Label phoneNumberError;
    @FXML
    private Label passwordError;
    @FXML
    private Label emailError;
    signUpManager customer_Excep = new signUpManager();
    final String type="customer";
    Coach c = new Coach();

    @FXML
    public void initialize() {
        genderChoiceBox.getItems().addAll("Male", "Female");
    }
    public void Load_to_Static_list() {
        Customer newCustomer = createCustomerInstance();
        //Subscription s = new Subscription(newCustomer.getId());
        String[] customerData = {
                newCustomer.getId(),
                newCustomer.getUser_name(),
                newCustomer.getPassword(),
                newCustomer.getPhone_number(),
                newCustomer.getEmail(),
                newCustomer.getAddress(),
                newCustomer.getGender(),
                "customer"
        };
        MainApplication.userList.add(customerData);
        MainApplication.customerArrayList.add(newCustomer);
    }
    public Customer createCustomerInstance() {
        Customer customer = new Customer();
        customer.setUser_name(Username.getText());
        customer.setPassword(Password.getText());
        customer.setPhone_number(phone_text.getText());
        customer.setEmail(email_text.getText());
        customer.setAddress(address_text.getText());
        customer.setGender(genderChoiceBox.getValue());
        return customer;
    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        try {
            customer_Excep.validateFields(Username.getText(), Password.getText(), phone_text.getText(),
                    email_text.getText(), address_text.getText(), genderChoiceBox.getValue());
            // Check for a valid username
            String entered_Username = Username.getText();
            try {
                if (customer_Excep.validUsername(entered_Username,type)){
                    usernameError.setVisible(false);
                }
            } catch (UsernameAlreadyExistsException e) {
                MainApplication.showAlert(e.getMessage());
                usernameError.setText(e.getMessage());
                usernameError.setVisible(true);
                return;
            }
        } catch (EmptyFieldException e) {
            MainApplication.showAlert(e.getMessage());
            return;
        }

        try {
                // Validate the password
            if (customer_Excep.validPassword(Password.getText())) {
                    passwordError.setVisible(false);
            }
        }catch (InvalidPasswordException e) {
                MainApplication.showAlert(e.getMessage());
                passwordError.setText(e.getMessage());
                passwordError.setVisible(true);
                return;
        }
        try {
            if (customer_Excep.validPhoneNumber(phone_text.getText(), type)) {
                    phoneNumberError.setVisible(false);
            }
        }catch (PhoneNumberException e) {
                MainApplication.showAlert(e.getMessage());
                phoneNumberError.setText(e.getMessage());
                phoneNumberError.setVisible(true);
                return;
        }
        try {
            if (customer_Excep.isValidEmail(email_text.getText())) {
                emailError.setVisible(false);
            }
        }catch (InvalidEmailException e) {
                MainApplication.showAlert(e.getMessage());
                emailError.setText(e.getMessage());
                emailError.setVisible(true);
                return;
        }

        Load_to_Static_list();
       // Files.WriteInFile("Registration.csv",type);
        Files.Load_coach_customer();
        c.assignCoachToCustomer(createCustomerInstance());
        MainApplication RegisterMain = new MainApplication();
        RegisterMain.changeScene("InBody_Membership.fxml");
    }
}

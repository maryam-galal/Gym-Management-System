package com.example.mainpage;
import com.example.mainpage.exceptions.loginExceptions.*;
import com.example.mainpage.exceptions.signupExceptions.EmptyFieldException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.io.*;

public class LoginController {
    protected String userName;
    @FXML
    private Button login;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label invalid_massage;
    @FXML
    private Label passwordError;
    @FXML
    private Label usernameError;
    MainApplication m =new MainApplication();
    LoginManager loginManager = new LoginManager();
    @FXML
    void login_check(MouseEvent event) throws IOException {
        try {
           if(loginManager.validateFields(usernameField.getText(), passwordField.getText()))
               invalid_massage.setVisible(false);
            String userType = loginManager.isValidUser(usernameField.getText(), passwordField.getText());
            System.out.println("Login successful! User Type: " + userType);
            passwordError.setVisible(false);
            usernameError.setVisible(false);
            // Handle the userType and change scene accordingly
            if ("coach".equals(userType)) {
                //updated by kenzy
                userName=usernameField.getText();
                Coach.SearchforName(userName);
                Coach.getSubscripedCustomers();
                Coach.SearchforCustomerData();
                Coach.SearchforCustomerInbody ();
                System.out.println("coach");
                m.changeScene("coachPage.fxml");
            } else if ("customer".equals(userType)) {
                userName=usernameField.getText();// updated by maya
               Customer.processName(userName);
                System.out.println("customer");
                m.changeScene("customerPage.fxml");
            } else if (userType.equals("admin")) {
                System.out.println("admin");
                m.changeScene("adminPage.fxml");
            }
        } catch (IncorrectUsernameException | IncorrectPasswordException e) {
            MainApplication.showAlert(e.getMessage());
            passwordField.setText("");usernameField.setText("");
            if(e instanceof IncorrectPasswordException){
                passwordError.setText(e.getMessage());
                passwordError.setVisible(true);
            } else if (e instanceof IncorrectUsernameException) {
                usernameError.setText(e.getMessage());
                usernameError.setVisible(true);
            }
        } catch (EmptyFieldException e) {
            MainApplication.showAlert(e.getMessage());
            invalid_massage.setText("Please fill in all fields.");
            invalid_massage.setVisible(true);
            System.out.println("Please fill in all fields.");
        }

    }
}


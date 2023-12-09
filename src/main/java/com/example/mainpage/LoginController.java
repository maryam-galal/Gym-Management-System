package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.*;
import java.io.*;

public class LoginController {
    private List<String[]> userList = new ArrayList<>();
    @FXML
    private Button login;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label invalid_massage;

    MainApplication m =new MainApplication();

    @FXML
    void logincheck(MouseEvent event) throws IOException {
        String enteredPassword = passwordField.getText();
        String enteredUsername = usernameField.getText();
        boolean loginSuccessful = false;

        for (String[] data : MainApplication.return_userList()) {
            if (data.length >= 7) {
                String usernameFromFile = data[1].trim();
                String passwordFromFile = data[5].trim();
                String userType = data[6].trim();
                if (enteredUsername.equals(usernameFromFile) && enteredPassword.equals(passwordFromFile)) {
                    loginSuccessful = true;
                    System.out.println("done");
                   if(userType.equals("coach")){
                        System.out.println("coach");
                        m.changeScene("coachPage.fxml");
                    }
                    else if (userType.equals("customer")) {
                        System.out.println("customer");
                        m.changeScene("customerPage.fxml");
                    } else if (userType.equals("admin")) {
                        System.out.println("admin");
                        m.changeScene("adminPage.fxml");
                    }
                    break;
                }
            }
        }

        if (loginSuccessful) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password");
            invalid_massage.setVisible(true);
            passwordField.setText("");
        }
    }
}


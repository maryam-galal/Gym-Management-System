package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.*;

public class LoginController {
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
    void login_check(MouseEvent event) throws IOException {
        String entered_Password = passwordField.getText();
        String entered_Username = usernameField.getText();
        boolean login_Successful = false;

        for (String[] data : MainApplication.userList) {
            if (data.length >= 7) {
                String username = data[1].trim();
                String password = data[2].trim();
                String userType = data[8].trim();
                if (entered_Username.equals(username) && entered_Password.equals(password)) {
                    login_Successful = true;
                    if(userType.equals("coach")){
                        System.out.println("coach");
                        m.changeScene("coachPage.fxml");
                    }
                    else if (userType.equals("customer")) {
                        System.out.println("customer");
                        m.changeScene("customerPage.fxml");
                    }
                    else if (userType.equals("admin")) {
                        System.out.println("admin");
                        m.changeScene("adminPage.fxml");
                    }
                    break;
                }
            }
        }

        if (login_Successful) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password");
            invalid_massage.setVisible(true);
            passwordField.setText("");
            usernameField.setText("");
        }
    }
}


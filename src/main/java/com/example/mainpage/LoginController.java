package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
public class LoginController {
    @FXML
    private Button login;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label invalid_massage;
    @FXML
    void logincheck(MouseEvent event) {
        String enteredPassword = passwordField.getText();
        String enteredUsername= usernameField.getText();
        if(enteredPassword.equals("administrator1")&&enteredUsername.equals("maryam")){
            System.out.println("log in successfully!");
        }
        if(enteredPassword.length()<10){
            System.out.println("invalid password");
            invalid_massage.setVisible(true);
            passwordField.setText("");
        }

    }
}

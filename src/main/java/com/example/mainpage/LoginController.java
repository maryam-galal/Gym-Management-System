package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.control.Label;
public class LoginController {
    @FXML
    private Button login;
    @FXML
    private PasswordField password_check;

    @FXML
    private TextField username_check;
    @FXML
    private Label invalid_massage;
    @FXML
    void logincheck(MouseEvent event) {
        String enteredPassword = password_check.getText();
        String enteredUsername=username_check.getText();
        if(enteredPassword.equals("administrator1")&&enteredUsername.equals("maryam")){
            System.out.println("log in successfully!");
        }
        if(enteredPassword.length()<10){
            System.out.println("invalid password");
            invalid_massage.setVisible(true);
            password_check.setText("");
        }

    }
}

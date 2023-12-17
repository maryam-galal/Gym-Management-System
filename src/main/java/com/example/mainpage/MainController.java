package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.scene.control.MenuItem;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class MainController implements Initializable{
    @FXML
    private MenuItem Address,phoneNumber;
    @FXML
    private Label gymName;
    @FXML
    private Button signupButton,loginButton;
    MainApplication m =new MainApplication();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            Address.setText(MainApplication.getGym().getAddress());
            phoneNumber.setText(MainApplication.getGym().getPhoneNumber());
            gymName.setText(MainApplication.getGym().getName());
    }

    @FXML
    void user_LogIn(MouseEvent event) throws IOException {
        m.changeScene("LogInPage.fxml");
    }
    @FXML
    void user_Register(MouseEvent event) throws IOException {
        m.changeScene("CoachOrCustomer.fxml");
    }
}
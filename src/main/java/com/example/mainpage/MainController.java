package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.List;
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
        List<Gym> gyms = MainApplication.getGyms();

        if (!gyms.isEmpty()) {
            Gym firstGym = gyms.get(0);
            Address.setText(firstGym.getAddress());
            phoneNumber.setText(firstGym.getPhoneNumber());
            gymName.setText(firstGym.getName());
        }
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
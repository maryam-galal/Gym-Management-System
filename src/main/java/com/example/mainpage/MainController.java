package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;
import javafx.scene.control.MenuItem;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class MainController implements Initializable{

    @FXML
    private MenuItem Address;
    @FXML
    private MenuItem phoneNumber;
    @FXML
    private Label gymName;
    @FXML
    private Button signupButton;
    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Assuming you have a list of gyms in MainApplication
        List<Gym> gyms = MainApplication.getGyms();

        if (!gyms.isEmpty()) {
            // Display information of the first gym in the list
            Gym firstGym = gyms.get(0);
            Address.setText(firstGym.getAddress());
            phoneNumber.setText(firstGym.getPhoneNumber());
            gymName.setText(firstGym.getName());
        }
    }
    @FXML
    void userLogIn(MouseEvent event) throws IOException {
        MainApplication logMain=new MainApplication();
        logMain.changeScene("LogInPage.fxml");
    }
    @FXML
    void userSignup(MouseEvent event) throws IOException {
        MainApplication Sign_upMain=new MainApplication();
        Sign_upMain.changeScene("CoachOrCustomer.fxml");
    }

}
package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class CoachOrCustomercontroller {

    MainApplication m =new MainApplication();

    @FXML
    void Register_coach(MouseEvent event) throws IOException {
        m.changeScene("Coach_RegistrationForm.fxml");

    }

    @FXML
    void Register_customer(MouseEvent event) throws IOException {
        m.changeScene("Customer_RegistrationForm.fxml");

    }
}

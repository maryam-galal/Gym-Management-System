package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class CoachOrCustomercontroller {

    @FXML
    void Register_coach(MouseEvent event) throws IOException {
        MainApplication coach_regMain=new MainApplication();
        coach_regMain.changeScene("RegistrationFormCoach.fxml");

    }

    @FXML
    void Register_customer(MouseEvent event) throws IOException {
        MainApplication regMain=new MainApplication();
        regMain.changeScene("RegistrationForm.fxml");

    }
}

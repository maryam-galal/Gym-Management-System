package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class RegistrationFormCoachcontroller {
    @FXML
    private TextField username, password, Phone_text, Email_text,Address_text;
    @FXML
    private ChoiceBox<String> GenderChoiceBox;

    @FXML
    public void Initialize() {
        String[] genderOptions = {"Male", "Female"};
        GenderChoiceBox.getItems().addAll(genderOptions);
    }
    @FXML
    void move_to_Next_page(MouseEvent event) throws IOException {
        MainApplication Sign_upMain=new MainApplication();
        Sign_upMain.changeScene("LoginPage.fxml");
    }
}

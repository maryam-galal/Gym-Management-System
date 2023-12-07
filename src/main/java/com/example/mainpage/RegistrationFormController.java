package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.*;
import java.io.*;

public class RegistrationFormController {
    @FXML
    private TextField Username, Password, phone_text, email_text,address_text;
    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    public void initialize() {
        String[] genderOptions = {"Male", "Female"};
        genderChoiceBox.getItems().addAll(genderOptions);
    }
    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        MainApplication Sign_upMain=new MainApplication();
        Sign_upMain.changeScene("InBody.fxml");
    }




}

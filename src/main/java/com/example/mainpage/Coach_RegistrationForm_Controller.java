package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Coach_RegistrationForm_Controller {
    @FXML
    private TextField Address_text,Email_text,Phone_text,password,username;
    @FXML
    private ChoiceBox <String> GenderChoiceBox;

    Coach coach = new Coach();

    @FXML
    public void initialize() {
        GenderChoiceBox.getItems().addAll("Male", "Female");
    }
// add data from text field to list
    public void AddToCoach() {

        coach.setGender(GenderChoiceBox.getValue());
        coach.setAddress(Address_text.getText());
        coach.setEmail(Email_text.getText());
        coach.setPassword(password.getText());
        coach.setUser_name(username.getText());
        coach.setPhone_number(Phone_text.getText());
        MainApplication.coachArrayList.add(coach);

    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        AddToCoach();
        Files.WriteInFile("Registration.csv");
        /*MainApplication RegisterMain = new MainApplication();
        RegisterMain.changeScene("InBody_Membership.fxml");*/
    }
}

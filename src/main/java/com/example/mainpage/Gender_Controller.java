package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Gender_Controller implements Initializable {
    @FXML
    private ChoiceBox<String> GenderSECB=new ChoiceBox<>();
    private String [] Gender={"Male","Female"};
    MainApplication main = new MainApplication();

//    @FXML
//    void BackToCoachPage(MouseEvent event) throws IOException {
//
//        main.changeScene("coachPage.fxml");
//    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        GenderSECB.getItems().addAll(Gender);
    }

}

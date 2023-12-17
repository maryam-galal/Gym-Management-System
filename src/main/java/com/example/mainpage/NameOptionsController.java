package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class NameOptionsController {
    MainApplication main= new MainApplication();
    @FXML
    void GoToNames(ActionEvent event) throws IOException {
        main.changeScene("SearchByName.fxml");
    }
    @FXML
    void GotToInbody(ActionEvent event) throws IOException {
        main.changeScene("SearchforInBody.fxml");
    }
}

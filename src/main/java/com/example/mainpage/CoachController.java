package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class CoachController {
    MainApplication main = new MainApplication();

    @FXML
    void search_by_gender(ActionEvent event) throws IOException {

        main.changeScene("SearchByGender.fxml");
    }

    @FXML
    void search_by_name(ActionEvent event) throws IOException {
        main.changeScene("NameOptions.fxml");
    }
    @FXML
    void DisplayByGender(ActionEvent event) {

    }

}

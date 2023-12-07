package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class InBodyController {
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField Height;
    @FXML
    private TextField BodyWeight;
    @FXML
    private TextField Bodyfat;
    @FXML
    private TextField Mass;
    @FXML
    private TextField menirals;
    @FXML
    private TextField water;
    @FXML
    private TextField protein;
    @FXML
    public void initialize() {
        datePicker.setValue(LocalDate.now()); // Set the current date
    }
}

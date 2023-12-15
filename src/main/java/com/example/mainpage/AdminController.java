package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AdminController{
    @FXML
    void go_to_3rdFunc(MouseEvent event) throws IOException {
        MainApplication m = new MainApplication();
        m.changeScene("Admin_Display.fxml");
    }
}
package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import java.io.IOException;


public class AdminController  {

    @FXML
    private Button MenuButton;
    @FXML
    private Button backButton;
    @FXML
    private Pane Slider;
    @FXML
    private Button display_subscribed;
    MainApplication m=new MainApplication();

    @FXML
    void SliderAppear(MouseEvent event) {
        MenuButton.setVisible(false);
        Slider.setVisible(true);

    }
    @FXML
    void hideSlider(MouseEvent event) {
      MenuButton.setVisible(true);
      Slider.setVisible(false);
    }
    @FXML
    void income(MouseEvent event) throws IOException {
        m.changeScene("GymIncome.fxml");
    }

    @FXML
    void AddCoach(ActionEvent event) throws IOException {
        m.changeScene("AddNewCoach.fxml");
    }

    @FXML
    void AddCustomer(ActionEvent event) throws IOException {
        m.changeScene("AddNewCustomer.fxml");
    }

    @FXML
    void AddEquipment(ActionEvent event) {

    }
    @FXML
    void DeleteEquipment(ActionEvent event) {

    }

    @FXML
    void EditCoach(ActionEvent event) throws IOException {
         m.changeScene("EditCoach.fxml");
    }

    @FXML
    void Edit_DeleteCustomer(ActionEvent event) throws IOException {
        m.changeScene("EditCustomer.fxml");

    }

    @FXML
    void EditEquipment(ActionEvent event) {

    }
    @FXML
    void go_to_3rdFunc(MouseEvent event) throws IOException {
        MainApplication m = new MainApplication();
        m.changeScene("Admin_Display.fxml");
    }


}

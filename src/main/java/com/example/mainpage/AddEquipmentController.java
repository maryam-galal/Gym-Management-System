package com.example.mainpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddEquipmentController implements Initializable {

    @FXML
    private TextField code;

    @FXML
    private DatePicker date;

    @FXML
    private TextField name;

    @FXML
    private TextField quantity;
    @FXML
    private Pane entryPane;
    @FXML
    private ChoiceBox<String> type;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.getItems().addAll("cardio","strength");
        type.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Check if the selected type is "cardio"
            if ("cardio".equals(newValue)) {
                entryPane.setVisible(true);
            } else {
                entryPane.setVisible(false);
            }
        });
    }
    @FXML
    void GoBack(MouseEvent event) throws IOException {
        MainApplication m=new MainApplication();
        m.changeScene("adminPage.fxml");
    }
    @FXML
    void saveNewEquipment(ActionEvent event) {
        System.out.println("Entering saveNewEquipment method");
        if(type.getValue().equals("cardio")){
            CardioEquipment c=new CardioEquipment(name.getText(),code.getText(),Integer.parseInt(quantity.getText()));
            c.setEntryDate(String.valueOf(date.getValue()));
            MainApplication.cardioEquipments.add(c);
        } else if (type.getValue().equals("strength")) {
            StrengthEquipment s=new StrengthEquipment(name.getText(),code.getText(),Integer.parseInt(quantity.getText()));
            MainApplication.strengthEquipments.add(s);
        }
        System.out.println(MainApplication.strengthEquipments.size());
        System.out.println(MainApplication.cardioEquipments.size());
    }
}

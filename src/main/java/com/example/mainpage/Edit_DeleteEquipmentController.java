package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Edit_DeleteEquipmentController implements Initializable {

    @FXML
    private TextField code;
    @FXML
    private TextArea entrydate;

    @FXML
    private Pane entrypane;

    @FXML
    private TextArea name;

    @FXML
    private TextArea quantity;

    @FXML
    private TextArea type;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(type.getText().equals("cardio")){
            entrypane.setVisible(true);
        }
    }
    private void clearFields() {
        name.clear();
        type.clear();
        entrydate.clear();
        quantity.clear();
        code.clear();
    }
    @FXML
    void DeleteEquipment(ActionEvent event) {
        String equipmentCode = code.getText();
        boolean equipmentFound = false;
        // Iterate over CardioEquipment list
        Iterator<CardioEquipment> cardioIterator = MainApplication.cardioEquipments.iterator();
        while (cardioIterator.hasNext()) {
            CardioEquipment cardioEquipment = cardioIterator.next();
            if (equipmentCode.equals(cardioEquipment.getEquipmentCode())) {
                equipmentFound = true;
                cardioIterator.remove();
                break;
            }
        }
        if (!equipmentFound) {
            Iterator<StrengthEquipment> strengthIterator = MainApplication.strengthEquipments.iterator();
            while (strengthIterator.hasNext()) {
                StrengthEquipment strengthEquipment = strengthIterator.next();
                if (equipmentCode.equals(strengthEquipment.getEquipmentCode())) {
                    equipmentFound = true;
                    strengthIterator.remove();
                    break;
                }
            }
        }

        if (!equipmentFound) {
            MainApplication.showAlert("No Matching Equipment");
            code.clear();
        } else {
            clearFields();
        }
    }

    @FXML
    void GetEquipment(ActionEvent event) {
        boolean EquipmentFound=false;
        for(CardioEquipment c :MainApplication.cardioEquipments){
            if(code.getText().equals(c.getEquipmentCode())){
                EquipmentFound=true;
                name.setText(c.getEquipmentName());
                quantity.setText(String.valueOf(c.getEquipmentQuantity()));
                type.setText(c.EquipmentType);
                entrydate.setText(c.getEntryDate());
            }
        }
        for(StrengthEquipment s :MainApplication.strengthEquipments){
            if(code.getText().equals(s.getEquipmentCode())){
                EquipmentFound=true;
                name.setText(s.getEquipmentName());
                quantity.setText(String.valueOf(s.getEquipmentQuantity()));
                type.setText(s.EquipmentType);
            }
        }
        if(!EquipmentFound){
            MainApplication.showAlert("No Matching Equipment");
            clearFields();
        }

    }
    @FXML
    void GoBack(MouseEvent event) throws IOException {
        MainApplication m=new MainApplication();
        m.changeScene("adminPage.fxml");
    }

    @FXML
    void saveEditedEquipment(ActionEvent event) {
        for (CardioEquipment c: MainApplication.cardioEquipments) {
            if (type.getText().equals("cardio")) {
               c.setEquipmentName(name.getText());
               c.setEquipmentCode(code.getText());
               c.setEquipmentQuantity(Integer.parseInt(quantity.getText()));
                c.setEntryDate(entrydate.getText());
                MainApplication.cardioEquipments.add(c);
            }
        }
        for(StrengthEquipment s: MainApplication.strengthEquipments){
            if(type.getText().equals("strength")){
                s.setEquipmentName(name.getText());
                s.setEquipmentCode(code.getText());
                s.setEquipmentQuantity(Integer.parseInt(quantity.getText()));
                MainApplication.strengthEquipments.add(s);
            }
        }        System.out.println(MainApplication.cardioEquipments.size());
        System.out.println(MainApplication.strengthEquipments.size());
    }
}

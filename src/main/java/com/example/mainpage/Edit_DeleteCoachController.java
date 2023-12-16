package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class Edit_DeleteCoachController {

    @FXML
    private TextArea Address_text;

    @FXML
    private TextArea email;

    @FXML
    private TextArea Endinghour;

    @FXML
    private TextArea Gender;

    @FXML
    private TextArea Phone_text;

    @FXML
    private TextArea Startinghour;

    @FXML
    private TextField coachId;

    @FXML
    private TextArea password;

    @FXML
    private TextArea username;
    private void clearFields() {
        username.clear();
        password.clear();
        Phone_text.clear();
        email.clear();
        Address_text.clear();
        Gender.clear();
        Startinghour.clear();
        Endinghour.clear();
    }

    @FXML
    void GetCoach(ActionEvent event) {
        boolean UserFound=false;
         for (Coach c : MainApplication.coachArrayList){
             if(coachId.getText().equals(c.getId())){
                 UserFound=true;
                 username.setText(c.getUser_name());
                 password.setText(c.getPassword());
                 Phone_text.setText(c.getPhone_number());
                 email.setText(c.getEmail());
                 Address_text.setText(c.getAddress());
                 Gender.setText(c.getGender());
                 Startinghour.setText(String.valueOf(c.getStartinghour()));
                 Endinghour.setText(String.valueOf(c.getEndinghour()));
             }
         }
         if(!UserFound){
             MainApplication.showAlert("No Matching Coach");clearFields();
         }
    }
    @FXML
    void DeleteCoach(MouseEvent event) {
        String coachIdToDelete = coachId.getText();
        Coach coachToDelete = null;
        // Find the coach with the specified ID
        for (Coach c : MainApplication.coachArrayList) {
            if (coachIdToDelete.equals(c.getId())) {
                coachToDelete = c;
                break; // Found the coach, exit the loop
            }
        }
        for(Subscription s : MainApplication.subscriptionArrayList){
            if(coachToDelete.getId().equals(s.getCoach_id())){
                for(Customer customer: MainApplication.customerArrayList){
                    if(s.getCustomer_id().equals(customer.getId())){
                        s.setCoach_id(coachToDelete.assignCoachToCustomer(customer));
                    }
                }
            }
        }



        if (coachToDelete != null) {
            MainApplication.coachArrayList.remove(coachToDelete);
            System.out.println("Coach with ID " + coachIdToDelete + " deleted.");
            clearFields();
        } else {
            System.out.println("Coach with ID " + coachIdToDelete + " not found.");
        }
    }


    @FXML
    void GoBack(MouseEvent event) throws IOException {
       MainApplication m=new MainApplication();
        m.changeScene("adminPage.fxml");
    }

    @FXML
    void SaveEditedCoach(MouseEvent event) {
        for(Coach c :MainApplication.coachArrayList){
            if(coachId.getText().equals(c.getId())){
                c.setUser_name(username.getText());
                c.setPassword(password.getText());
                c.setAddress(Address_text.getText());
                c.setStartinghour(Integer.parseInt(Startinghour.getText()));
                c.setEmail(email.getText());
                c.setEndinghour(Integer.parseInt(Endinghour.getText()));
                c.setPhone_number(Phone_text.getText());
                c.setGender(Gender.getText());
            }
        }
    }

}

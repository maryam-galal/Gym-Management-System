package com.example.mainpage;
import com.example.mainpage.exceptions.signupExceptions.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import javafx.scene.control.Label;
public class Coach_RegistrationForm_Controller {
    @FXML
    private TextField Address_text,Email_text,Phone_text,password,username;
    @FXML
    private ChoiceBox <String> GenderChoiceBox;
    @FXML
    private Label emailError;

    @FXML
    private Label passwordError;

    @FXML
    private Label phoneNumberError;
    @FXML
    private Label usernameError;
    signUpManager coach_excep = new signUpManager();
    final String type="coach";
    Coach coach = new Coach();

    @FXML
    public void initialize() {
        GenderChoiceBox.getItems().addAll("Male", "Female");
    }
 //add data from text field to list
    public void AddToCoach() {
        Coach newCoach = createCoachInstance();
        String[] coachData = {
                newCoach.getId(),
                newCoach.getUser_name(),
                newCoach.getPassword(),
                newCoach.getPhone_number(),
                newCoach.getEmail(),
                newCoach.getAddress(),
                newCoach.getGender(),
                "coach"  // Assuming "coach" is the user type for coaches
        };

        // Add the string array to the user list
        MainApplication.userList.add(coachData);
        MainApplication.coachArrayList.add(newCoach);
    }
    public Coach createCoachInstance() {
       Coach coach = new Coach();
       coach.setGender(GenderChoiceBox.getValue());
        coach.setAddress(Address_text.getText());
        coach.setEmail(Email_text.getText());
        coach.setPassword(password.getText());
        coach.setUser_name(username.getText());
        coach.setPhone_number(Phone_text.getText());

       // MainApplication.coachArrayList.add(coach);
        return coach;
    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        MainApplication backToLogIn=new MainApplication();
        try {
            coach_excep.validateFields(username.getText(), password.getText(), Phone_text.getText(),
                    Email_text.getText(), Address_text.getText(), GenderChoiceBox.getValue());
            // Check for a valid username
            String entered_Username = username.getText();
            try {
                if (coach_excep.validUsername(entered_Username,type)) {
                    usernameError.setVisible(false);
                }
            } catch (UsernameAlreadyExistsException e) {
                MainApplication.showAlert(e.getMessage());
                usernameError.setText(e.getMessage());
                usernameError.setVisible(true);
                return;
            }
        } catch (EmptyFieldException e) {
            MainApplication.showAlert(e.getMessage());
            return;
        }

        try {
            // Validate the password
            if (coach_excep.validPassword(password.getText())) {
                passwordError.setVisible(false);
            }
        } catch (InvalidPasswordException e) {
            MainApplication.showAlert(e.getMessage());
            passwordError.setText(e.getMessage());
            passwordError.setVisible(true);
            return;
        }

        try {
            // Validate phone number
            if (coach_excep.validPhoneNumber(Phone_text.getText(),type)) {
                phoneNumberError.setVisible(false);
            }
        } catch (PhoneNumberException e) {
            MainApplication.showAlert(e.getMessage());
            phoneNumberError.setText(e.getMessage());
            phoneNumberError.setVisible(true);
            return;
        }
        try {
            // Validate phone number
            if (coach_excep.isValidEmail(Email_text.getText())) {
                emailError.setVisible(false);
            }
        } catch (InvalidEmailException e) {
            MainApplication.showAlert(e.getMessage());
            emailError.setText(e.getMessage());
            emailError.setVisible(true);
            return;
        }
        AddToCoach();
        Files.WriteInFile("Registration.csv",type);
        backToLogIn.changeScene("LogInPage.fxml");

    }
}

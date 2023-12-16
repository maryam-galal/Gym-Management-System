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
    @FXML
    private ChoiceBox<Integer> Startinghour;
    @FXML
    private ChoiceBox<Integer> Endinghour;
    @FXML
    private Label HoursError;
    signUpManager coach_excep = new signUpManager();
    final String type="coach";

    @FXML
    public void initialize() {
        GenderChoiceBox.getItems().addAll("Male", "Female");
        Startinghour.getItems().addAll(7,8,9,10,11,12,13,14);
        Endinghour.getItems().addAll(17,18,19,20,21,22,23,24);
    }
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
                "coach",
                String.valueOf(newCoach.getStartinghour()),
                String.valueOf(newCoach.getEndinghour())
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
        coach.setStartinghour(Startinghour.getValue());
        coach.setEndinghour((Endinghour.getValue()));
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
        try {
            // Validate phone number
            if (coach_excep.validWorkingHours(Startinghour.getValue(),Endinghour.getValue())){
                HoursError.setVisible(false);
            }
        } catch (WorkingHoursException e) {
            MainApplication.showAlert(e.getMessage());
            HoursError.setText(e.getMessage());
            HoursError.setVisible(true);
            return;
        }
        AddToCoach();
      //  Files.WriteInFile("Registration.csv",type);
        backToLogIn.changeScene("LogInPage.fxml");

    }
}

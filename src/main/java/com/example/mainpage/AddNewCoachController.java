package com.example.mainpage;
import com.example.mainpage.exceptions.signupExceptions.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class AddNewCoachController implements Initializable {

    @FXML
    private TextField Address_text;

    @FXML
    private TextField Email_text;

    @FXML
    private ChoiceBox<Integer> Endinghour;

    @FXML
    private ChoiceBox<String> GenderChoiceBox;

    @FXML
    private TextField Phone_text;

    @FXML
    private ChoiceBox<Integer> Startinghour;


    @FXML
    private TextField password;


    @FXML
    private TextField username;

    signUpManager coach_excep = new signUpManager();
    final String type="coach";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    public void SaveNewCoach(MouseEvent mouseEvent) throws IOException {
        MainApplication backToLogIn=new MainApplication();
        try {
            coach_excep.validateFields(username.getText(), password.getText(), Phone_text.getText(),
                    Email_text.getText(), Address_text.getText(), GenderChoiceBox.getValue());
            // Check for a valid username
            String entered_Username = username.getText();
            try {
                if (coach_excep.validUsername(entered_Username,type)) {
                }
            } catch (UsernameAlreadyExistsException e) {
                MainApplication.showAlert(e.getMessage());

                return;
            }
        } catch (EmptyFieldException e) {
            MainApplication.showAlert(e.getMessage());
            return;
        }

        try {
            // Validate the password
            if (coach_excep.validPassword(password.getText())) {

            }
        } catch (InvalidPasswordException e) {
            MainApplication.showAlert(e.getMessage());

            return;
        }

        try {
            // Validate phone number
            if (coach_excep.validPhoneNumber(Phone_text.getText(),type)) {

            }
        } catch (PhoneNumberException e) {
            MainApplication.showAlert(e.getMessage());

            return;
        }
        try {
            // Validate phone number
            if (coach_excep.isValidEmail(Email_text.getText())) {
            }
        } catch (InvalidEmailException e) {
            MainApplication.showAlert(e.getMessage());

            return;
        }
        try {
            // Validate phone number
            if (coach_excep.validWorkingHours(Startinghour.getValue(),Endinghour.getValue())){

            }
        } catch (WorkingHoursException e) {
            MainApplication.showAlert(e.getMessage());
            return;
        }
        AddToCoach();
        //Files.WriteInFile("Registration.csv",type);
        backToLogIn.changeScene("LogInPage.fxml");

    }
    @FXML
    void GoBack(MouseEvent event) throws IOException {
        MainApplication m=new MainApplication();
        m.changeScene("adminPage.fxml");
    }
}


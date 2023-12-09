package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RegistrationFormCoach_Controller {
    @FXML
    private TextField Address_text,Email_text,Phone_text,password,username;
    @FXML
    private ChoiceBox <String> GenderChoiceBox;

    @FXML
    public void initialize() {
        GenderChoiceBox.getItems().addAll("Male", "Female");
    }
    @FXML
    void move_to_Next_page(MouseEvent event) throws IOException {
        MainApplication RegisterMain=new MainApplication();
        RegisterMain.changeScene("LoginPage.fxml");
    }


    Coach coach = new Coach();
    public ArrayList<Coach> ArrayListCoach() throws IOException {
        ArrayList<Coach> CoachList = new ArrayList<>();

        coach.gender = GenderChoiceBox.getValue();
        coach.address = Address_text.getText();
        coach.email = Email_text.getText();
        coach.Password = password.getText();
        coach.name = username.getText();
        coach.phone_number = Phone_text.getText();
        CoachList.add(coach);

        return CoachList;
    }

    @FXML
    void Move_to_Next_page(MouseEvent event) throws IOException {
        FileWriter fw = new FileWriter("Registration.csv", true);
        PrintWriter pw = new PrintWriter(fw, false);

        //boolean headersWritten = false;
        /*if (!headersWritten) {
            pw.println("address,name,email,gender,phone_number,Password,user_type");
            headersWritten = true; // Set the flag to true after writing headers
        }*/

        for (Coach c : ArrayListCoach()) {
            pw.print(c.address + "," + c.name + "," + c.email + "," + c.gender + "," + c.phone_number + "," + c.Password +","+ "coach"+"\n");
            System.out.println("done");
        }
        pw.flush();
        pw.close();

        /*MainApplication RegisterMain = new MainApplication();
        RegisterMain.changeScene("InBody_Membership.fxml");*/
    }


}

package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.*;
import java.io.*;

public class LoginController {
    private List<String[]> userList = new ArrayList<>(); // read all data from the file
    @FXML
    private Button login;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label invalid_massage;
    @FXML
    void logincheck(MouseEvent event) throws IOException {
        String enteredPassword = passwordField.getText();
        String enteredUsername = usernameField.getText();
        boolean loginSuccessful = false;
        try (Scanner fileScanner = new Scanner(new File("C:\\Users\\ROAA\\IdeaProjects\\GYM\\src\\main\\java\\com\\example\\mainpage\\login.csv"))) {
            while (fileScanner.hasNextLine()) {
                // split data in file into an array of strings making each array an array of all of data of each coulmb in this file
                String[] data = fileScanner.nextLine().split(",");
                userList.add(data); // Add each row to the list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String[] data : userList) {
            if (data.length >= 2) {
                String usernameFromFile = data[0].trim();
                String passwordFromFile = data[1].trim();
                String userType = data[2].trim();
                if (enteredUsername.equals(usernameFromFile) && enteredPassword.equals(passwordFromFile)) {
                    // Matching username and password found
                    loginSuccessful = true;
                    if(userType.equals("coach")){
                        System.out.println("coach");
                        MainApplication CoachMain=new MainApplication();
                        CoachMain.changeScene("coachPage.fxml");
                    }
                    else if (userType.equals("customer")) {
                        System.out.println("customer");
                        MainApplication CustomerMain=new MainApplication();
                        CustomerMain.changeScene("customerPage.fxml");
                    } else if (userType.equals("admin")) {
                        System.out.println("admin");
                        MainApplication AdminMain=new MainApplication();
                        AdminMain.changeScene("adminPage.fxml");
                    }
                    break;
                }

            }
        }

        if (loginSuccessful) {
            System.out.println("Login successful!");
            // Add your code here for what should happen after successful login
        } else {
            System.out.println("Invalid username or password");
            invalid_massage.setVisible(true);
            passwordField.setText("");
        }
    }
}


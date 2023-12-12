package com.example.mainpage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.image.Image;

public class MainApplication extends Application {
    private static List<Gym> gyms;
 protected static ArrayList<String[]> userList = new ArrayList<>();
 protected static ArrayList<Customer> customerArrayList = new ArrayList<>();
 protected static ArrayList<Coach> coachArrayList = new ArrayList<>();
 protected static ArrayList<InBody> inBodyArrayList = new ArrayList<>();

 protected static ArrayList<String[]> inBody_Membership_Data = new ArrayList<>();
 protected static ArrayList<Membership_Plan> membershipPlanArrayList = new ArrayList<>();

    private static Stage primarystage;

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static List<Gym> readGymsFromFile(String filePath) {
        List<Gym> gyms = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String name = bufferedReader.readLine();
            String address = bufferedReader.readLine();
            String phoneNumber = bufferedReader.readLine();

            if (name != null && address != null && phoneNumber != null) {
                Gym gym = new Gym(name.trim(), address.trim(), phoneNumber.trim());
                gyms.add(gym);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gyms;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void start(Stage stage) throws IOException {

        primarystage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        // load all data to userList
         Files.Load_ArrayList("C:\\Users\\ROAA\\IdeaProjects\\GYM\\Registration.csv", userList);
        // only load the customers
        Files.LoadCustomer(userList, customerArrayList);
        // only load the coaches
         Files.LoadCoach(userList, coachArrayList);
        // load data from inbody_membership file
         Files.Load_ArrayList("InBody_Membership.csv",inBody_Membership_Data);
        // load data to inbody list
        Files.LoadInBody(inBody_Membership_Data, inBodyArrayList);
        // Set the application icon
        stage.getIcons().add(new Image("file:C:\\Users\\ROAA\\IdeaProjects\\GYM\\src\\main\\resources\\com\\example\\mainpage\\Gym Icon.png"));
        stage.setTitle("Fitness Gym");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void changeScene(String fxml) throws IOException {
        // System.out.println("Changing scene to: " + fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primarystage.setScene(scene);
        primarystage.setResizable(false);
        primarystage.show();

    }
    @Override
    public void init() {
        String filePath = "C:\\Users\\ROAA\\IdeaProjects\\GYM\\src\\main\\resources\\com\\example\\mainpage\\Gyminfo_class.txt";
        gyms = readGymsFromFile(filePath);
    }

    public static List<Gym> getGyms() {
        return gyms;
    }



    public static void main(String[] args) {
        launch(args);
    }
}

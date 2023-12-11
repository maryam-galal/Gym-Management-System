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
    protected  static ArrayList<String[]> userList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();
    ArrayList<Coach> coachList = new ArrayList<>();
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

        //reading file info
        try (Scanner fileScanner = new Scanner(new File("D:\\Projects\\2nd Year\\OOP\\GYM\\Registration.csv"))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                userList.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //saving data into lists
        for (String[] data : userList) {
            if (data.length >= 7) {
                String userType = data[6].trim();
                if (userType.equals("customer")) {
                    Customer customer = new Customer();
                    customer.setUser_name(data[0].trim());
                    customer.setPassword(data[1].trim());
                    customer.setPhone_number(data[2].trim());
                    customer.setEmail(data[3].trim());
                    customer.setAddress(data[4].trim());
                    customer.setGender(data[5].trim());
                    customerList.add(customer);
                }
                else if (userType.equals("coach")){
                    Coach coach = new Coach();
                    coach.setUser_name(data[0].trim());
                    coach.setPassword(data[1].trim());
                    coach.setPhone_number(data[2].trim());
                    coach.setEmail(data[3].trim());
                    coach.setAddress(data[4].trim());
                    coach.setGender(data[5].trim());
                    coachList.add(coach);
                }
            }
        }

        // Set the application icon
        stage.getIcons().add(new Image("file:D:\\Projects\\2nd Year\\OOP\\GYM\\src\\main\\resources\\com\\example\\mainpage\\Gym Icon.png"));
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
        String filePath = "D:\\Projects\\2nd Year\\OOP\\GYM\\src\\main\\resources\\com\\example\\mainpage\\Gyminfo_class.txt";
        gyms = readGymsFromFile(filePath);
    }

    public static List<Gym> getGyms() {
        return gyms;
    }

    public static ArrayList<String[]> return_userList(){
        return userList;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

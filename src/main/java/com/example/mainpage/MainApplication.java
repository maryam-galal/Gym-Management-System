package com.example.mainpage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainApplication extends Application {
    protected static ArrayList<Customer> customerArrayList = new ArrayList<>();
    protected static ArrayList<Coach> coachArrayList = new ArrayList<>();
    protected static ArrayList<InBody> InBodyList = new ArrayList<>();
    protected static ArrayList<Subscription> subscriptionArrayList = new ArrayList<>();
    protected static ArrayList<String[]> userList = new ArrayList<>();
    protected static ArrayList<String[]> InBody_Data = new ArrayList<>();
    protected static ArrayList<String []> Subscription_Data = new ArrayList<>();
    protected static ArrayList<String []> EquipmentsFromFile= new ArrayList<>();
    protected static ArrayList<CardioEquipment> cardioEquipments=new ArrayList<>();
    protected static ArrayList<StrengthEquipment> strengthEquipments=new ArrayList<>();
    private static Stage primarystage;

    @Override
    public void start(Stage stage) throws IOException {
        primarystage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        // load all data to userList
        Files.Load_ArrayList("Registration.csv");
        Files.Load_coach_customer();
        Files.Load_ArrayList("InBody.csv");
        Files.Load_InBody();
        Files.Load_ArrayList("Subscription.csv");
        Files.Load_Subscription();
        Files.load_Equipment("gym_equipment.csv");
        Files.load_cardio_strength();

        System.out.println(cardioEquipments.size());
        System.out.println(strengthEquipments.size());
        System.out.println(EquipmentsFromFile.size());
        System.out.println(userList.size());
        System.out.println(customerArrayList.size());
        System.out.println(coachArrayList.size());
        System.out.println(InBodyList.size());
        System.out.println(subscriptionArrayList.size());
        System.out.println(InBody_Data.size());
        System.out.println(Subscription_Data.size());

        // Set the application icon
        stage.getIcons().add(new Image("file:C:\\Users\\Mariam\\IdeaProjects\\mainpage\\src\\main\\resources\\com\\example\\mainpage\\Gym Icon.png"));
        stage.setTitle("Fitness Gym");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(windowEvent -> {
            Files.updateFile("gym_equipment.csv");
            Files.updateFile("Registration.csv");
            Files.updateFile("InBody.csv");
            Files.updateFile("Subscription.csv");
            Platform.exit();
        });
    }
    public void changeScene(String fxml) throws IOException {
        // System.out.println("Changing scene to: " + fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primarystage.setScene(scene);
        primarystage.setResizable(false);
        primarystage.show();

    }
    public static Gym getGym() {
        Gym gym=new Gym();
        return gym;
    }
    public static ArrayList<String[]> return_userList(){
        return userList;
    }
    public static ArrayList<Customer> return_customerList(){
        return customerArrayList;
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);

        try {
            // Load your icon image
            Image icon = new Image("file:C:\\Users\\Mariam\\IdeaProjects\\mainpage\\src\\main\\resources\\com\\example\\mainpage\\error_icon.png");


            ImageView imageView = new ImageView(icon);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);

            alert.getDialogPane().setGraphic(imageView);

            // Set icon in the title bar of the alert
            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.getIcons().add(icon);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        alert.showAndWait();
    }
}
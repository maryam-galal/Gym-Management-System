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
    private static List<Gym> gyms;
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

        //habiba--------------------------------------------------------------------------------------------
        //  List<Equipments>equipmentList = new ArrayList<>();

        // Read data from CSV file
/*
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine(); // Skip header row
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                int id = Integer.parseInt(values[1]);
                int quantity = Integer.parseInt(values[2]);

                equipmentList.add(new Equipments(name, id, quantity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Print loaded equipment
        System.out.println("Loaded equipment:");
        for (Equipments equipment : equipmentList) {
            System.out.println(equipment);
        }

        // Add new equipment
        Equipments newEquipment = new Equipments("Treadmill", 1, 10);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Dumbbellset", 2, 2);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("ChestPress", 3, 3);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Aerobic Steps", 4, 15);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("ArmCurl", 5, 2);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Bench Press", 6, 3);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Cable Row", 7, 2);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Kettle bells", 8, 2);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Lat pulldown", 9, 3);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Leg Press", 10, 1);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Shoulder press", 11, 3);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Spin Bike", 12, 4);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Stability Ball", 13, 5);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Stair Climber", 14, 3);
        equipmentList.add(newEquipment);

        newEquipment = new Equipments("Triceps Press", 15, 3);
        equipmentList.add(newEquipment);


        // Save updated list to CSV file
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write("Name,ID,Quantity\n"); // Write header row
            for (Equipments equipment : equipmentList) {
                writer.write(equipment.toCsvLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        //-------------------------------------------------------------------------------------------------------------------


        // Set the application icon
        stage.getIcons().add(new Image("file:D:\\Projects\\2nd Year\\OOP\\GYM\\src\\main\\resources\\com\\example\\mainpage\\Gym Icon.png"));
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
    public static ArrayList<Customer> return_customerList(){
        return customerArrayList;
    }
    public static ArrayList<Coach> return_coachList(){
        return coachArrayList;
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
            Image icon = new Image("file:D:\\Projects\\2nd Year\\OOP\\GYM\\src\\main\\resources\\com\\example\\mainpage\\error_icon.png");

            // Create an ImageView with the icon
            ImageView imageView = new ImageView(icon);
            imageView.setFitWidth(48); // Set the width of the icon
            imageView.setFitHeight(48); // Set the height of the icon

            // Set the graphic of the Alert's DialogPane to the ImageView
            alert.getDialogPane().setGraphic(imageView);

            // Set the application icon in the title bar of the alert
            Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
            alertStage.getIcons().add(icon);
        } catch (IllegalArgumentException e) {
            // Handle the exception (e.g., log the error)
            e.printStackTrace();
        }

        // Show the alert
        alert.showAndWait();
    }
}
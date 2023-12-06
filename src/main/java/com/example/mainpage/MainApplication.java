package com.example.mainpage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
//comment
public class MainApplication extends Application {
    private static List<Gym> gyms;
    private static Stage primarystage;
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


    @Override
    public void start(Stage stage) throws IOException {
        primarystage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainPage.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene = new Scene(root);
        // Set the application icon
        stage.getIcons().add(new Image("file:C:\\Users\\Mariam\\IdeaProjects\\mainpage\\src\\main\\resources\\com\\example\\mainpage\\laa set scene gymIcon-removebg-preview.png"));
        stage.setTitle("Fitness Gym");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void init() {
        String filePath = "C:\\Users\\Mariam\\IdeaProjects\\mainpage\\src\\main\\java\\com\\example\\mainpage\\Gyminfo_class.txt";
        gyms = readGymsFromFile(filePath);
    }

    public void changeScene(String fxml)throws IOException{
       // System.out.println("Changing scene to: " + fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml));
        Parent root=fxmlLoader.load();
        Scene scene = new Scene(root);
        primarystage.setScene(scene);
       // System.out.println("Scene changed successfully.");
        primarystage.setResizable(false);
        primarystage.show();

    }
    public static List<Gym> getGyms() {
        return gyms;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

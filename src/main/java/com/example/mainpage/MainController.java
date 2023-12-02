package com.example.mainpage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import java.util.List;
public class MainController {
    @FXML
    private Button InfoButton;
    @FXML
    private Button backbutton;
    @FXML
    private ScrollPane infoPanel;
    @FXML
    private Label addressLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneNoLabel;
    @FXML
    void InfoPanelDisplay(MouseEvent event) {
        InfoButton.setVisible(false);
        infoPanel.setVisible(true);
        List<Gym> gyms = MainApplication.getGyms();
        if (!gyms.isEmpty()) {
            Gym firstGym = gyms.get(0);
            nameLabel.setText("Name: " + firstGym.getName());
            addressLabel.setText("Address: " + firstGym.getAddress());
            phoneNoLabel.setText("Phone Number: " + firstGym.getPhoneNumber());
        }

    }
    @FXML
    void handleBackButtonClick(MouseEvent event) {
        InfoButton.setVisible(true);
        infoPanel.setVisible(false);
    }
}
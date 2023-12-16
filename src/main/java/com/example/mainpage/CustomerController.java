package com.example.mainpage;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController {
    @FXML
    private Button okk;

    @FXML
    private DatePicker specific_data;

    @FXML
    private Label label_0;

    @FXML
    private Label label_1;

    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Label label_5;

    @FXML
    private Label label_6;

    @FXML
    private Label label_7;
    @FXML
    private Label label_10;
    @FXML
    private Label label_12;

    @FXML
    private Label label_11;

    @FXML
    private Label label_8;

    @FXML
    private Label label_9;
    @FXML
    private Button member_buttom;

    @FXML
    private TextField member_id;
    @FXML
    private TextField id_coach_info;

    @FXML
    private Label label_coach_name;

    @FXML
    private Label label_coach_phone;
    @FXML
    private Button display_kilos;

    @FXML
    private TextField kilos_id;
    @FXML
    private Label label_target;
    @FXML
    private Label label_coach_hours_end;

    @FXML
    private Label label_coach_hours_start;
  //  @FXML
  //  private TableView<Equipments> equipmentTableView;

   /* public void initialize() {
        try {
            for (String[] dataS : MainApplication.Equipment_array_list) {
                column_1.setCellValueFactory(data -> new SimpleStringProperty(dataS[0]));

            }
            // Assuming your equipmentList is already populated
            ObservableList<String[]> equipmentData = FXCollections.observableArrayList(MainApplication.Equipment_array_list);
            equipmentTableView.setItems(equipmentData);
        }catch (Exception e){
            e.getMessage();
        }
    }*/
  /* @Override
   public void initialize(URL location, ResourceBundle resources) {
       initializeTableView();
   }

    private void initializeTableView() {
        // Initialize TableColumn properties
        TableColumn<Equipments, String>  column_1 = new TableColumn<>("Name");
        TableColumn<Equipments, Integer>  column_2 = new TableColumn<>("Id");
       TableColumn<Equipments, Integer>  column_3 = new TableColumn<>("Quantity");

        column_1.setCellValueFactory(new PropertyValueFactory<>("EquipmentName"));
        column_2.setCellValueFactory(new PropertyValueFactory<>("EquipmentId"));
        column_3.setCellValueFactory(new PropertyValueFactory<>("EquipmentQuantity"));

        // Set properties for other columns
       // equipmentTableView.getColumns().clear(); // Clear existing columns
      // equipmentTableView.getColumns().addAll(column_1, column_2);
    }*/




    MainApplication m = new MainApplication();

    @FXML
    void coachinformation(ActionEvent event) throws IOException {
        m.changeScene("Coach_info.fxml");
    }

    @FXML
    void gymequipment(ActionEvent event) throws IOException {
      m.changeScene("Display_equ_arraylist.fxml");

       // m.changeScene("display_equ_1.fxml");

    }

    @FXML
    void in_body_information(ActionEvent event) throws IOException {
      m.changeScene("display_in-body.fxml");
    }

    @FXML
    void membership_plan(ActionEvent event) throws IOException {
        m.changeScene("membership_plan.fxml");

    }
    @FXML
    void Display_inbody(ActionEvent event) {

        boolean found = false;
        for (String[] data : MainApplication.InBody_Data) {
            if (data.length >= 9) {
                String DataFromFile = data[1].trim();
                if (specific_data.getValue().toString().equals(DataFromFile)) {
                    label_0.setText(data[1].trim());
                    label_1.setText(data[2].trim());
                    label_2.setText(data[3].trim());
                    label_3.setText(data[4].trim());
                    label_4.setText(data[5].trim());
                    label_5.setText(data[6].trim());
                    label_6.setText(data[7].trim());
                    label_7.setText(data[8].trim());
                    found = true;
                }
           }
        }
        if (!found){
            label_0.setText("invalid date");
            label_1.setText("invalid date");
            label_2.setText("invalid date");
            label_3.setText("invalid date");
            label_4.setText("invalid date");
            label_5.setText("invalid date");
            label_6.setText("invalid date");
            label_7.setText("invalid date");
            System.out.println("invalid date");
        }

    }
    @FXML
    void display_member_buttom(ActionEvent event) {

        String memberId = member_id.getText();

        System.out.println("Subscriptions for Customer ID: " + memberId);
        boolean memberplan_found = false;

        if (!MainApplication.Subscription_Data.isEmpty()) {
            for (String[] data : MainApplication.Subscription_Data) {
                String idFromFile = data[0].trim();
             //   System.out.println("Data ID: " + idFromFile); // Debug statement

                if (idFromFile.equals(memberId)) {
                    label_8.setText(data[3].trim());
                    label_9.setText(data[4].trim());
                    label_10.setText(data[5].trim());
                    label_11.setText(data[6].trim());
                    label_12.setText(data[7].trim());
                    memberplan_found = true;
                }
            }
        } else {
            System.out.println("inBodyArrayListFromFile is empty!");
        }
        if (!memberplan_found){
            label_8.setText("Invalid date");
            label_9.setText("Invalid date");
            label_10.setText("Invalid date");
            label_11.setText("Invalid date");
            label_12.setText("Invalid date");
            System.out.println("Invalid date");

        }
    }

    @FXML
    void display_coach_info(ActionEvent event) {
       // String memberId_for_coach_info = id_coach_info.getText();
        String get = Customer.get();
       // System.out.println("Coach info by Customer ID: " + memberId_for_coach_info);
        for (String[] data : MainApplication.Subscription_Data) {
            String idFromFile = data[0].trim();
            //   System.out.println("Data ID: " + idFromFile); // Debug statement
            if (idFromFile.equals(get)) {// hena el beyhessll
                for (String[] user_data : MainApplication.userList){
                    if (data[1].equals(user_data[0])){
                        label_coach_name.setText(user_data[1].trim());
                        label_coach_phone.setText(user_data[3].trim());
                        label_coach_hours_start.setText(user_data[8].trim());
                        label_coach_hours_end.setText(user_data[9].trim());
                    }
                }

            }
        }

    }

    @FXML
    void kilos_to_be_reduced(ActionEvent event) throws IOException {
       m.changeScene("kilos_to_be_reduced.fxml");
    }

    @FXML
    void display_kilos_to_reduced(ActionEvent event) {
        String id_for_kilos = kilos_id.getText();
        for (String[] data : MainApplication.InBody_Data){
            String idFromFile = data[0].trim();
            if(id_for_kilos.equals(idFromFile)){
                if(Double.valueOf(data[4]) - 100 > Double.valueOf(data[7])){
                    label_target.setText("You are underweight");
                }else if(Double.valueOf(data[4]) - 100 < Double.valueOf(data[7])){
                    Double calc = Double.valueOf(data[7]) - (Double.valueOf(data[4]) - 100 );
                    label_target.setText(String.valueOf(calc));
                }else{
                    label_target.setText("Your weight is perfect");
                }
            }

        }

    }
    @FXML
    void Cancel(ActionEvent event) throws IOException {
        m.changeScene("customerPage.fxml");
    }
    @FXML
    void next_page1(ActionEvent event) throws IOException {
        m.changeScene("display_equ_2.fxml");
    }


    @FXML
    void nest_page_2(ActionEvent event) throws IOException {
        m.changeScene("display_equ_3.fxml");
    }

    @FXML
    void next_page3(ActionEvent event) throws IOException {
        m.changeScene("display_equ_4.fxml");
    }


}
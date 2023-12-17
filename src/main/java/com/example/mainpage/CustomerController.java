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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable  {
    @FXML
    private DatePicker inbody_datePicker2;
    @FXML
    private TextField BodyWeight2,Bodyfat2,Height2,Mass2,minerals2,protein2,water2;
    @FXML
    private Button okk;

    @FXML
    private DatePicker specific_data;

    @FXML
    private Label label_0, label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11, label_12 ;
    @FXML
    private Label label_coach_name;

    @FXML
    private Label label_coach_phone;
    @FXML
    private Label label_target;
    @FXML
    private Label label_coach_hours_end;

    @FXML
    private Label label_coach_hours_start;
    @FXML
    TableColumn<String[], String> column_1 = new TableColumn<>("Name");
    @FXML
    TableColumn<String[], String> column_2 = new TableColumn<>("Id");
    @FXML
    TableColumn<String[], Integer> column_3 = new TableColumn<>("Quantity");
    @FXML
    TableColumn<String[], String> column_4 = new TableColumn<>("Equipment Type");
    @FXML
    public TableView<String []> equipmentTableView;

    @FXML
    private ChoiceBox<String> plan_ChoiceBox2;
    @FXML
    private DatePicker plan_DatePicker2;
    @FXML
    private TextField NumberOfMonths2;

    @FXML
    private RadioButton gold;
    @FXML
    private RadioButton silver;
    Coach co = new Coach();


   @Override
    public void initialize(URL location, ResourceBundle resources) {
       initializeTableView();
   }

    private void initializeTableView() {
        // Initialize TableColumn properties
        try {
            if (equipmentTableView != null) {
                equipmentTableView.getColumns().clear();

                column_1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[0]));
                column_2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[1]));
                column_3.setCellValueFactory(data -> new SimpleIntegerProperty(Integer.parseInt(data.getValue()[2])).asObject());
                column_4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[3]));

                equipmentTableView.getColumns().addAll(column_1, column_2, column_3, column_4);

                ObservableList<String[]> equipmentData = FXCollections.observableArrayList(MainApplication.EquipmentsFromFile);
                equipmentTableView.setItems(equipmentData);
            } else {
               // System.err.println("equipmentTableView is null. Check your FXML file to ensure proper initialization.");
            }

        } catch (Exception e) {
            System.err.println("Exception during TableView initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }


    MainApplication m = new MainApplication();

    @FXML
    void coachinformation(ActionEvent event) throws IOException {
        m.changeScene("Coach_info.fxml");
    }

    @FXML
    void gymequipment(ActionEvent event) throws IOException {
        m.changeScene("Display_equ_arraylist.fxml");
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
    void Renew_Subscription(ActionEvent event) throws IOException {
        m.changeScene("Renew_Subscription.fxml");
    }
    @FXML
    void Display_inbody(ActionEvent event) {

        String get = Customer.get();
        boolean found = false;
        for (String[] data : MainApplication.InBody_Data) {
                String DataFromFile = data[1].trim();
                if (specific_data.getValue().toString().equals(DataFromFile) && data[0].equals(get)) {
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
        String get = Customer.get();

        System.out.println("Subscriptions for Customer ID: " + get);
        boolean memberplan_found = false;

        if (!MainApplication.Subscription_Data.isEmpty()) {
            for (String[] data : MainApplication.Subscription_Data) {
                String idFromFile = data[0].trim();

                if (idFromFile.equals(get)) {
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
        String get = Customer.get();
        for (String[] data : MainApplication.Subscription_Data) {
            String idFromFile = data[0].trim();
            if (idFromFile.equals(get)) {
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
        String get = Customer.get();
        for (String[] data : MainApplication.InBody_Data){
            String idFromFile = data[0].trim();
            if(get.equals(idFromFile)){
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
    void Renew_inbody(ActionEvent event) throws IOException {
        m.changeScene("Renew_inbody.fxml");
    }

    @FXML
    void Cancel(ActionEvent event) throws IOException {
        m.changeScene("customerPage.fxml");
    }
    public InBody Create_Inbody_Instance2() {
        InBody b = new InBody();
        String get = Customer.get();
        b.setCustomer_id(get);
        b.height = Double.parseDouble(Height2.getText());
        b.body_fat = Double.parseDouble(Bodyfat2.getText());
        b.Date_of_InBody = String.valueOf(inbody_datePicker2.getValue());
        b.mass = Double.parseDouble(Mass2.getText());
        b.minerals_var = Double.parseDouble(minerals2.getText());
        b.protein_var = Double.parseDouble(protein2.getText());
        b.total_weight = Double.parseDouble(BodyWeight2.getText());
        b.water_weight = Double.parseDouble(water2.getText());
        return b;
    }

    public void AddTo_InBody2() {
        InBody in = Create_Inbody_Instance2();
        String[] Inbody_data = {
                in.getCustomer_id(),
                in.getDate_of_InBody(),
                String.valueOf(in.getMass()),
                String.valueOf(in.getBody_fat()),
                String.valueOf(in.getHeight()),
                String.valueOf(in.getMinerals_var()),
                String.valueOf(in.getProtein_var()),
                String.valueOf(in.getTotal_weight()),
                String.valueOf(in.getWater_weight())
        };
        MainApplication.InBody_Data.add(Inbody_data);
        MainApplication.InBodyList.add(in);
    }

    @FXML
    void save_renew(ActionEvent event) throws IOException {

        String get = Customer.get();
        String dateBefore = "";

        System.out.println("Subscriptions for Customer ID: " + get);
        for (String[] data : MainApplication.InBody_Data) {
            String idFromFile = data[0].trim();
            if (idFromFile.equals(get)) {
                dateBefore = data[1].trim();
            }
        }

        if (!dateBefore.isEmpty()) {
            LocalDate currentDate = inbody_datePicker2.getValue();
            LocalDate inBodyDate = LocalDate.parse(dateBefore);
            long daysDifference = ChronoUnit.DAYS.between(inBodyDate, currentDate);


            if (daysDifference < 30) {
                // Show an error message using Alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Date Difference Error");
                alert.setHeaderText(null);
                alert.setContentText("The difference between dates must be at least 30 days! \n you can't renew your inbody now");
                alert.showAndWait();
                m.changeScene("customerPage.fxml");
            } else {
                AddTo_InBody2();
                System.out.println("Done");
                m.changeScene("customerPage.fxml");
            }
        } else {
            System.out.println("No previous InBody data found for the customer!");
        }
    }
   @FXML
   public Subscription Create_sub_instance2() {
       String choice = "";
       //Subscription s = new Subscription(c.getId(), co.getId());
        Subscription s = new Subscription();
        s.plan = new Membership_Plan();
       String get = Customer.get();
       String var ="";
       String name = "";
       for (String[] data : MainApplication.Subscription_Data){
           if (data[0].equals(get)){
               var = data[1];
               name =data[2];
           }
       }
       s.setCustomer_id(get);
       s.setCoach_id(var);
       s.setCustomer_name(name);



        if(silver.isSelected()){
            choice = "Silver Plan";
        } else if (gold.isSelected()) {
            choice = "Gold Plan";
        }
       //  String choice = plan_ChoiceBox2.getValue();
        s.plan.choice = choice;
        s.plan.start_date = String.valueOf(plan_DatePicker2.getValue());
        s.plan.number_of_months = Integer.parseInt(NumberOfMonths2.getText());
        s.plan.choose_plan();
        return s;
    }
    public void AddTo_Subscription2() {
        Subscription s = Create_sub_instance2();
        String[]  sub_data = {
                s.getCustomer_id(),
                s.getCoach_id(),
                s.getCustomer_name(),
                s.plan.getChoice(),
                s.plan.getStart_date(),
                String.valueOf(s.plan.getNumber_of_months()),
                String.valueOf(s.plan.getDays_per_week()),
                String.valueOf(s.plan.getPlan_price())
        };
        MainApplication.Subscription_Data.add(sub_data);
        MainApplication.subscriptionArrayList.add(s);
    }

    @FXML
    void save_renew_Subscription(ActionEvent event) throws IOException {
       //AddTo_Subscription2();
        String get = Customer.get();
        String dateBefore = "";
        String number_of_month = "";

        System.out.println("Subscriptions for Customer ID: " + get);
        for (String[] data : MainApplication.Subscription_Data) {
            String idFromFile = data[0].trim();
            if (idFromFile.equals(get)) {
                dateBefore = data[4].trim();
                number_of_month = data[5].trim();
            }
        }

        if (!dateBefore.isEmpty()) {
            LocalDate currentDate = plan_DatePicker2.getValue();
            LocalDate inBodyDate = LocalDate.parse(dateBefore);
            long MonthsDifference = ChronoUnit.MONTHS.between(inBodyDate, currentDate);
            System.out.println(MonthsDifference);

            if (MonthsDifference < Long.parseLong(number_of_month)) {
                // Show an error message using Alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Date Difference Error");
                alert.setHeaderText(null);
                alert.setContentText("Your Subscription is still going");
                alert.showAndWait();
                m.changeScene("customerPage.fxml");
            } else {
                AddTo_Subscription2();
                System.out.println("Done");
                m.changeScene("customerPage.fxml");
            }
        } else {
            System.out.println("No previous InBody data found for the customer!");
        }
    }


}
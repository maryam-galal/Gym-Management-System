package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class AdminDisplay_Controller implements Initializable {

    @FXML
    private TableView<Customer> subscribed_customers, Customers_forCoach;
    @FXML
    private TableView<Coach> Coaches;
    @FXML
    private TextField Day, Month, Month1, coachID;
    @FXML
    private Label income;
    @FXML
    private Rectangle income_frame;

    @FXML
    void GoBack(MouseEvent event) throws IOException {
        MainApplication m = new MainApplication();
        m.changeScene("adminPage.fxml");
    }


    //Display all the customers that subscribed to the gym in a given month/day
    //----------------------------------------------------------------------------------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize_subscribed_customers();
        initialize_Customers_forCoach();
        initialize_Coaches();
    }

    private void initialize_subscribed_customers() {
        // Initialize TableColumn properties
        TableColumn<Customer, String> customerIDColumn = new TableColumn<>("Customer ID");
        TableColumn<Customer, String> userNameColumn = new TableColumn<>("User Name");

        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("user_name"));

        // Set properties for other columns
        subscribed_customers.getColumns().clear(); // Clear existing columns
        subscribed_customers.getColumns().addAll(customerIDColumn, userNameColumn);
    }

    @FXML
    private void Search_ByMonth(MouseEvent event) {
        subscribed_customers.getItems().clear(); // Clear existing items

        for (String[] s : MainApplication.Subscription_Data) {
            if (s.length > 4) {
                String month = s[4].substring(5, 7);
                if (month.equals(Month.getText()) || (month.startsWith("0") && month.substring(1).equals(Month.getText()))) {
                    subscribed_customers.setVisible(true);
                    Customer customer = new Customer();
                    customer.setId(s[0]);
                    customer.setUser_name(s[2]);
                    subscribed_customers.getItems().add(customer);
                }
            }
        }
    }

    @FXML
    private void Search_ByDay(MouseEvent event) {
        subscribed_customers.getItems().clear(); // Clear existing items

        for (String[] s : MainApplication.Subscription_Data) {
            if (s.length > 4) {
                String day = s[4].substring(8, 10);
                if (day.equals(Day.getText()) || (day.startsWith("0") && day.substring(1).equals(Day.getText()))) {
                    subscribed_customers.setVisible(true);
                    Customer customer = new Customer();
                    customer.setId(s[0]);
                    customer.setUser_name(s[2]);
                    subscribed_customers.getItems().add(customer);
                }
            }
        }
    }
    //----------------------------------------------------------------------------------------------


    //Display the GYM income in a given month.
    //----------------------------------------------------------------------------------------------
    public void calculate_income(MouseEvent event) {
        double Income = 0.0;
        for (String[] s : MainApplication.Subscription_Data) {
            if (s.length > 4) {
                String month = s[4].substring(5, 7);
                if (month.equals(Month1.getText()) || (month.startsWith("0") && month.substring(1).equals(Month1.getText()))) {
                    Income += Double.parseDouble(s[7]);
                }
            }
        }
        income.setText(String.valueOf(Income));
        income.setVisible(true);
        income_frame.setVisible(true);
    }
    //----------------------------------------------------------------------------------------------


    //Display all the customers of a specific coach.
    //----------------------------------------------------------------------------------------------
    private void initialize_Customers_forCoach() {
        // Initialize TableColumn properties
        TableColumn<Customer, String> IDColumn = new TableColumn<>("Customer ID");
        TableColumn<Customer, String> NameColumn = new TableColumn<>("User Name");

        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("user_name"));

        // Set properties for other columns
        Customers_forCoach.getColumns().clear(); // Clear existing columns
        Customers_forCoach.getColumns().addAll(IDColumn, NameColumn);
    }

    public void display_customers(MouseEvent event) {
        Customers_forCoach.getItems().clear(); // Clear existing items

        for (String[] s : MainApplication.Subscription_Data) {
            if (s[1].equals(coachID.getText())) {
                Customers_forCoach.setVisible(true);
                Customer customer = new Customer();
                customer.setId(s[0]);
                customer.setUser_name(s[2]);
                Customers_forCoach.getItems().add(customer);
            }
        }
    }
    //----------------------------------------------------------------------------------------------


    //Display the coaches sorted in terms of the most assigned number of customers to the coaches
    //----------------------------------------------------------------------------------------------
    private void initialize_Coaches() {
        // Initialize TableColumn properties
        TableColumn<Coach, String> IDColumn = new TableColumn<>("Customer ID");
        TableColumn<Coach, String> NameColumn = new TableColumn<>("User Name");

        IDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("user_name"));

        // Set properties for other columns
        Coaches.getColumns().clear(); // Clear existing columns
        Coaches.getColumns().addAll(IDColumn, NameColumn);
    }
    public void display_coaches(MouseEvent event) {
        Coaches.getItems().clear(); // Clear existing items

        for (Coach c : MainApplication.coachArrayList){
            int customers_counter = 0;
            for (String[] s : MainApplication.Subscription_Data) {
                if (c.getId().equals(s[1])) {
                    customers_counter++;
                }
            }
            c.setNumberOfCustomers(customers_counter);
        }
        MainApplication.coachArrayList.sort(Comparator.comparingInt(Coach::getNumberOfCustomers).reversed());
        for (Coach c : MainApplication.coachArrayList) {
            Coaches.setVisible(true);
            Coach coach = new Coach();
            coach.setId(c.getId());
            coach.setUser_name( c.getUser_name());
            Coaches.getItems().add(coach);
        }
    }
    //----------------------------------------------------------------------------------------------

}

package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDisplay_Controller implements Initializable {

    @FXML
    private TableView<Customer> subscribed_customers;
    @FXML
    private TextField Day;
    @FXML
    private TextField Month;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
    }

    private void initializeTableView() {
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

}

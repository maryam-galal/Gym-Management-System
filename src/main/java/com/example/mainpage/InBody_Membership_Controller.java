package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Arrays;

public class InBody_Membership_Controller {
    //INBODY
    @FXML
    private DatePicker inbody_datePicker;
    @FXML
    private TextField BodyWeight,Bodyfat,Height,Mass,minerals,protein,water;

    //MEMBERSHIP PLAN
    @FXML
    private ChoiceBox<String> plan_ChoiceBox;
    @FXML
    private DatePicker plan_DatePicker;
    @FXML
    private TextField NumberOfMonths;

    public void initialize() {
        plan_ChoiceBox.getItems().addAll("Silver Plan \n (3 Days per Week)", "Gold Plan \n (6 Days per Week, with less session price + higher discount)");
    }



    public InBody Create_Inbody_Instance() {
        InBody b = new InBody();
        b.height = Double.parseDouble(Height.getText());
        b.body_fat = Double.parseDouble(Bodyfat.getText());
        b.Date_of_InBody = String.valueOf(inbody_datePicker.getValue());
        b.mass = Double.parseDouble(Mass.getText());
        b.minerals_var = Double.parseDouble(minerals.getText());
        b.protein_var = Double.parseDouble(protein.getText());
        b.total_weight = Double.parseDouble(BodyWeight.getText());
        b.water_weight = Double.parseDouble(water.getText());
        return b;
    }

    public void AddTo_InBody() {
        InBody in = Create_Inbody_Instance();
        String[] Inbody_data = {
                Subscription.getCustomer_id(),
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

    public void AddTo_Subscription() {
        Membership_Plan p = Create_plan_instance();
        String[] plan_data = {
                Subscription.getCustomer_id(),
                p.getChoice(),
                p.getStart_date(),
                String.valueOf(p.getNumber_of_months()),
                String.valueOf(p.getDays_per_week()),
                String.valueOf(p.getPlan_price())
        };
        MainApplication.Subscription_Data.add(plan_data);
        MainApplication.membershipPlanArrayList.add(p);
    }
    @FXML
    public Membership_Plan Create_plan_instance() {
        Membership_Plan plan = new Membership_Plan();
        String choice = plan_ChoiceBox.getValue();
        plan.choice = choice.substring(0, choice.indexOf("\n")).trim();
        plan.start_date = String.valueOf(plan_DatePicker.getValue());
        plan.number_of_months = Integer.parseInt(NumberOfMonths.getText());
        plan.choose_plan();
        return plan;
    }



    @FXML
    public void save(MouseEvent mouseEvent) throws IOException {
        MainApplication backTOlogIn=new MainApplication();
        AddTo_InBody();
        AddTo_Subscription();
        Subscription.findAvailableCoach();
        Files.WriteInFile("InBody.csv","customer");
        Files.WriteInFile("Subscription.csv","customer");
        backTOlogIn.changeScene("LogInPage.fxml");

    }
}

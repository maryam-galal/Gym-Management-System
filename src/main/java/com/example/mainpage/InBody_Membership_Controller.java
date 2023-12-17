package com.example.mainpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

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
    Coach co = new Coach();

    public void initialize() {
        plan_ChoiceBox.getItems().addAll("Silver Plan \n (3 Days per Week)", "Gold Plan \n (6 Days per Week, with less session price + higher discount)");
    }
    public InBody Create_Inbody_Instance() {
        Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);
        InBody b = new InBody();
        b.setCustomer_id(lastCustomer.getId());
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
    public Subscription Create_sub_instance() {
        //Subscription s = new Subscription(c.getId(), co.getId());
        Subscription s = new Subscription();
        s.plan = new Membership_Plan();
        Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);
        String assignedcoachid=co.assignCoachToCustomer(lastCustomer);
        s.setCoach_id(assignedcoachid);
        s.setCustomer_id(lastCustomer.getId());
        s.setCustomer_name(lastCustomer.getUser_name());
        String choice = plan_ChoiceBox.getValue();
        s.plan.choice = choice.substring(0, choice.indexOf("\n")).trim();
        s.plan.start_date = String.valueOf(plan_DatePicker.getValue());
        s.plan.number_of_months = Integer.parseInt(NumberOfMonths.getText());
        s.plan.choose_plan();
        return s;
    }
    public void AddTo_Subscription() {
        Subscription s = Create_sub_instance();
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
    public void save(MouseEvent mouseEvent) throws IOException {
        MainApplication backTOlogIn=new MainApplication();
        AddTo_InBody();
        AddTo_Subscription();
        //Subscription.findAvailableCoach();
        //Files.WriteInFile("InBody.csv","customer");
        //Files.WriteInFile("Subscription.csv","customer");
        backTOlogIn.changeScene("LogInPage.fxml");

    }

}

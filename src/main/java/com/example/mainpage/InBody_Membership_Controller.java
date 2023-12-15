package com.example.mainpage;

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


    public void initialize() {
        plan_ChoiceBox.getItems().addAll("Silver Plan \n (3 Days per Week)", "Gold Plan \n (6 Days per Week, with less session price + higher discount)");
    }

    public void Load_static_InBodyArraylist() {
        InBody b = new InBody();
        b.height = Double.parseDouble(Height.getText());
        b.body_fat = Double.parseDouble(Bodyfat.getText());
        b.Date_of_InBody = String.valueOf(inbody_datePicker.getValue());
        b.mass = Double.parseDouble(Mass.getText());
        b.minerals_var = Double.parseDouble(minerals.getText());
        b.protein_var = Double.parseDouble(protein.getText());
        b.total_weight = Double.parseDouble(BodyWeight.getText());
        b.water_weight = Double.parseDouble(water.getText());
        System.out.println("loaded");
        MainApplication.InBodyList.add(b);
    }

    @FXML
    public void Load_static_PlanArrayList() {
        Membership_Plan plan = new Membership_Plan();
        String choice = plan_ChoiceBox.getValue();
        plan.choice = choice.substring(0, choice.indexOf("\n")).trim();
        plan.start_date = String.valueOf(plan_DatePicker.getValue());
        plan.number_of_months = Integer.parseInt(NumberOfMonths.getText());
        plan.choose_plan();
        MainApplication.membershipPlanArrayList.add(plan);

    }
//    public void Load_to_Subscription_Data_InBody_Data(){
//        InBody inBody= Load_static_InBodyArraylist();
//        Membership_Plan plan=Load_static_PlanArrayList();
//        Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);
//        String[] inbodyData ={
//                lastCustomer.getId(), inBody.Date_of_InBody, String.valueOf(inBody.mass), String.valueOf(inBody.body_fat),
//                String.valueOf(inBody.height),String.valueOf(inBody.minerals_var), String.valueOf(inBody.protein_var),
//                String.valueOf(inBody.total_weight), String.valueOf(inBody.water_weight)};
//        MainApplication.InBody_Data.add(inbodyData);
//        String[] subscribtionData={
//                lastCustomer.getId(),Subscription.getCoach_id(),lastCustomer.getUser_name(),"Coach", plan.choice,
//                plan.start_date, String.valueOf(plan.number_of_months), String.valueOf(plan.days_per_week),
//                String.valueOf(plan.plan_price)};
//        MainApplication.Subscription_Data.add(subscribtionData);
//    }


    @FXML
    public void save(MouseEvent mouseEvent) throws IOException {
        MainApplication backTOlogIn=new MainApplication();
        Load_static_InBodyArraylist();
        Load_static_PlanArrayList();
        Subscription.findAvailableCoach();
        //Load_to_Subscription_Data_InBody_Data();
        Files.WriteInFile("InBody.csv","customer");
        Files.WriteInFile("Subscription.csv","customer");
        backTOlogIn.changeScene("LogInPage.fxml");

    }
}

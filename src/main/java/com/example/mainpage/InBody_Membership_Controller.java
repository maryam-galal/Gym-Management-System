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

    InBody b = new InBody();

    //MEMBERSHIP PLAN
    @FXML
    private ChoiceBox<String> plan_ChoiceBox;
    @FXML
    private DatePicker plan_DatePicker;
    @FXML
    private TextField NumberOfMonths;

    Membership_Plan plan = new Membership_Plan();

    public void initialize() {
        plan_ChoiceBox.getItems().addAll("Silver Plan \n (3 Days per Week)", "Gold Plan \n (6 Days per Week, with less session price + higher discount)");
    }

    public void Load_static_InBodyArraylist() {
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
        String choice = plan_ChoiceBox.getValue();
        plan.choice = choice.substring(0, choice.indexOf("\n")).trim();
        plan.start_date = String.valueOf(plan_DatePicker.getValue());
        plan.number_of_months = Integer.parseInt(NumberOfMonths.getText());
        plan.choose_plan();
        MainApplication.membershipPlanArrayList.add(plan);
    }


    @FXML
    public void save(MouseEvent mouseEvent) throws IOException {
        MainApplication backTOlogIn=new MainApplication();
        Load_static_InBodyArraylist();
        Load_static_PlanArrayList();
        Subscription.findAvailableCoach();
        Files.WriteInFile("InBody.csv","customer");
        Files.WriteInFile("Subscription.csv","customer");

        backTOlogIn.changeScene("LogInPage.fxml");

    }
}

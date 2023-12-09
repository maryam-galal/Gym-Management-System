package com.example.mainpage;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class InBody_Membership_Controller {
    //INBODY
    @FXML
    private DatePicker inbody_datePicker;
    @FXML
    private TextField BodyWeight;
    @FXML
    private TextField Bodyfat;
    @FXML
    private TextField Height;
    @FXML
    private TextField Mass;
    @FXML
    private TextField minerals;
    @FXML
    private TextField protein;
    @FXML
    private TextField water;
    InBody b = new InBody();

    //MEMBERSHIP PLAN
    @FXML
    private ChoiceBox<String> plan_ChoiceBox;
    @FXML
    private DatePicker plan_DatePicker;
    @FXML
    private TextField NumberOfMonths;
    Membership_Plan plan = new Membership_Plan();

    /*@FXML
    public void initialize() {
        inbody_datePicker.setValue(LocalDate.now()); // Set the current date
    }*/

    public void initialize() {
        plan_ChoiceBox.getItems().addAll("Silver Plan \n (3 Days per Week)", "Gold Plan \n (6 Days per Week, with less session price + higher discount)");
    }

    public ArrayList<InBody> ArrayListInBody() throws IOException {
        ArrayList<InBody> InbodyList = new ArrayList<>();

        b.height = Double.parseDouble(Height.getText());
        b.body_fat = Double.parseDouble(Bodyfat.getText());
        b.Date_of_InBody = String.valueOf(inbody_datePicker.getValue());
        b.mass = Double.parseDouble(Mass.getText());
        b.minerals_var = Double.parseDouble(minerals.getText());
        b.protein_var = Double.parseDouble(protein.getText());
        b.total_weight = Double.parseDouble(BodyWeight.getText());
        b.water_weight = Double.parseDouble(water.getText());
        InbodyList.add(b);

        return InbodyList;
    }

    @FXML
    public ArrayList<Membership_Plan> ArrayListPlan() throws IOException {
        ArrayList<Membership_Plan> PlanList = new ArrayList<>();
        String c = plan_ChoiceBox.getValue();
        plan.choice = c.substring(0, c.indexOf("\n")).trim();
        plan.number_of_months = Integer.parseInt(NumberOfMonths.getText());
        plan.start_date = String.valueOf(plan_DatePicker.getValue());
        plan.choose_plan();
        PlanList.add(plan);

        return PlanList;
    }

    @FXML
    public void save(MouseEvent mouseEvent) throws IOException {
        FileWriter fw = new FileWriter("Inbody_Membership.csv", true);
        PrintWriter pw = new PrintWriter(fw, false);

        //boolean headersWritten = false;
        /*if (!headersWritten) {
            pw.println("Date_of_InBody, mass,body_fat, height,minerals_var, protein_var, total_weight, water_weight, choice, number_of_months, start_date, days_per_week");
            headersWritten = true; // Set the flag to true after writing headers
        }*/

        for (InBody Value : ArrayListInBody()) {
            pw.print(Value.Date_of_InBody + "," + Value.mass + "," + Value.body_fat + "," + Value.height + "," + Value.minerals_var + "," + Value.protein_var + "," + Value.total_weight + "," + Value.water_weight + ",");
        }
        for (Membership_Plan p : ArrayListPlan()) {
            pw.print(p.choice + "," + p.number_of_months + "," + p.start_date + "," + p.days_per_week + "\n");
            System.out.println("done");
        }
        pw.flush();
        pw.close();
    }
}

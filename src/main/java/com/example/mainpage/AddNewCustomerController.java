package com.example.mainpage;
import com.example.mainpage.exceptions.signupExceptions.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class AddNewCustomerController {

    @FXML
    private TextField BodyWeight;

    @FXML
    private TextField Bodyfat;

    @FXML
    private TextField Height;

    @FXML
    private TextField Mass;

    @FXML
    private TextField NumberOfMonths;

    @FXML
    private TextField Password;

    @FXML
    private TextField Username;

    @FXML
    private TextField address_text;

    @FXML
    private TextField email_text;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private DatePicker inbody_datePicker;

    @FXML
    private TextField minerals;

    @FXML
    private TextField phone_text;

    @FXML
    private ChoiceBox<String> plan_ChoiceBox;

    @FXML
    private DatePicker plan_DatePicker;

    @FXML
    private TextField protein;

    @FXML
    private TextField water;
    @FXML
    private Button saveButton;
    @FXML
    private Button BackButton;
    signUpManager customer_Excep = new signUpManager();
    final String type="customer";
    InBody b = new InBody();
    Coach co = new Coach();
    public void initialize() {
        genderChoiceBox.getItems().addAll("Male","Female");
        plan_ChoiceBox.getItems().addAll("Silver Plan \n (3 Days per Week)", "Gold Plan \n (6 Days per Week, with less session price + higher discount)");

    }
    public void Load_to_Static_list() {
        Customer newCustomer = createCustomerInstance();
        String[] customerData = {
                newCustomer.getId(),
                newCustomer.getUser_name(),
                newCustomer.getPassword(),
                newCustomer.getPhone_number(),
                newCustomer.getEmail(),
                newCustomer.getAddress(),
                newCustomer.getGender(),
                "customer"
        };
        MainApplication.userList.add(customerData);
        MainApplication.customerArrayList.add(newCustomer);
    }
    public Customer createCustomerInstance() {
        Customer customer = new Customer();
        customer.setUser_name(Username.getText());
        customer.setPassword(Password.getText());
        customer.setPhone_number(phone_text.getText());
        customer.setEmail(email_text.getText());
        customer.setAddress(address_text.getText());
        customer.setGender(genderChoiceBox.getValue());
        return customer;
    }
    public void Load_static_InBodyArraylist() {
        Customer lastCustomer = MainApplication.customerArrayList.get(MainApplication.customerArrayList.size() - 1);
        b.setCustomer_id(lastCustomer.getId());
        b.height = Double.parseDouble(Height.getText());
        b.body_fat = Double.parseDouble(Bodyfat.getText());
        b.Date_of_InBody = String.valueOf(inbody_datePicker.getValue());
        b.mass = Double.parseDouble(Mass.getText());
        b.minerals_var = Double.parseDouble(minerals.getText());
        b.protein_var = Double.parseDouble(protein.getText());
        b.total_weight = Double.parseDouble(BodyWeight.getText());
        b.water_weight = Double.parseDouble(water.getText());
        //System.out.println("loaded");
        MainApplication.InBodyList.add(b);
    }
    @FXML
    public void Load_static_PlanArrayList() {
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
        MainApplication.subscriptionArrayList.add(s);
    }
    @FXML
    void saveNewCustomer(ActionEvent event) throws IOException {
        System.out.println("savvvvv");
        try {
            customer_Excep.validateFields(Username.getText(), Password.getText(), phone_text.getText(),
                    email_text.getText(), address_text.getText(), genderChoiceBox.getValue());
            // Check for a valid username
            String entered_Username = Username.getText();
            try {
                if (customer_Excep.validUsername(entered_Username,type)){

                }
            } catch (UsernameAlreadyExistsException e) {
                MainApplication.showAlert(e.getMessage());
                return;
            }
        } catch (EmptyFieldException e) {
            MainApplication.showAlert(e.getMessage());
            return;
        }
        try {
            // Validate the password
            if (customer_Excep.validPassword(Password.getText())) {

            }
        }catch (InvalidPasswordException e) {
            MainApplication.showAlert(e.getMessage());

            return;
        }
        try {
            if (customer_Excep.validPhoneNumber(phone_text.getText(), type)) {

            }
        }catch (PhoneNumberException e) {
            MainApplication.showAlert(e.getMessage());

            return;
        }
        try {
            if (customer_Excep.isValidEmail(email_text.getText())) {

            }
        }catch (InvalidEmailException e) {
            MainApplication.showAlert(e.getMessage());

            return;
        }

        Load_to_Static_list();
        Load_static_InBodyArraylist();
        Load_static_PlanArrayList();
    }
    @FXML
    void GoBack(MouseEvent event) throws IOException {
MainApplication M= new MainApplication();
M.changeScene("adminPage.fxml");
    }

}
package com.example.mainpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Iterator;

public class Edit_DeleteCustomerController {

    @FXML
    private TextArea address;

    @FXML
    private TextArea bodyfat;

    @FXML
    private TextArea bodywater;

    @FXML
    private TextArea bodyweight;

    @FXML
    private TextArea email;

    @FXML
    private TextArea gender;

    @FXML
    private TextArea height;

    @FXML
    private TextArea inbodydate;

    @FXML
    private TextArea mass;

    @FXML
    private TextArea minerals;

    @FXML
    private TextArea noMonths;
    @FXML
    private TextArea assignedcoachId;
    @FXML
    private TextArea password;

    @FXML
    private TextArea phonenumber;

    @FXML
    private TextArea plan;

    @FXML
    private TextArea protein;
    @FXML
    private TextArea price;

    @FXML
    private Button saveButton;

    @FXML
    private TextArea startdate;
    @FXML
    private TextArea daysperweek;
    @FXML
    private TextArea username;
    @FXML
    private TextField id;
    MainApplication m=new MainApplication();
    @FXML
    void GetCustomer(ActionEvent event) {
        boolean UserFound=false;
        for(Customer c: MainApplication.return_customerList()){
            if(id.getText().equals(c.getId())){
                UserFound=true;
                username.setText(c.getUser_name());
                password.setText(c.getPassword());
                phonenumber.setText(c.getPhone_number());
                email.setText(c.getEmail());
                address.setText(c.getAddress());
                gender.setText(c.getGender());
                for(InBody i:MainApplication.InBodyList){
                    if(id.getText().equals(i.getCustomer_id())) {
                        inbodydate.setText(i.getDate_of_InBody());
                        mass.setText(String.valueOf(i.getMass()));
                        bodyfat.setText(String.valueOf(i.getBody_fat()));
                        height.setText(String.valueOf(i.getHeight()));
                        minerals.setText(String.valueOf(i.getMinerals_var()));
                        protein.setText(String.valueOf(i.getProtein_var()));
                        bodyweight.setText(String.valueOf(i.getTotal_weight()));
                        bodywater.setText(String.valueOf(i.getWater_weight()));
                    }}
                for(Subscription s :MainApplication.subscriptionArrayList){
                    if(id.getText().equals(s.getCustomer_id())) {
                        assignedcoachId.setText(s.getCoach_id());
                        plan.setText(s.plan.getChoice());
                        startdate.setText(s.plan.getStart_date());
                        noMonths.setText(String.valueOf(s.plan.getNumber_of_months()));
                        daysperweek.setText(String.valueOf(s.plan.getDays_per_week()));
                        price.setText(String.valueOf(s.plan.getPlan_price()));
                    }
                }
            }
        }if(!UserFound){
            MainApplication.showAlert("No Matching Customer");
            id.clear();
        }
    }
    @FXML
    void GoBack(ActionEvent event) throws IOException{
        m.changeScene("adminPage.fxml");
    }

    @FXML
    void saveEditedCustomer(ActionEvent event) throws IOException {
        for(Customer c: MainApplication.return_customerList()){
            if(id.getText().equals(c.getId())){
                c.setUser_name(username.getText());
               c.setPassword(password.getText());
                c.setPhone_number(phonenumber.getText());
               c.setEmail(email.getText());
                c.setAddress(address.getText());
                c.setGender(gender.getText());

        }
    }
        for(InBody i:MainApplication.InBodyList){
            if(id.getText().equals(i.getCustomer_id())){
                i.setDate_of_InBody(inbodydate.getText());
                i.setMass(Double.parseDouble(mass.getText()));
                i.setBody_fat(Double.parseDouble(bodyfat.getText()));
                i.setHeight(Double.parseDouble(height.getText()));
                i.setMinerals_var(Double.parseDouble(minerals.getText()));
                i.setProtein_var(Double.parseDouble(protein.getText()));
                i.setTotal_weight(Double.parseDouble(bodyweight.getText()));
                i.setWater_weight(Double.parseDouble(bodywater.getText()));
            }
        }
        for(Subscription s : MainApplication.subscriptionArrayList) {
            if(id.getText().equals(s.getCustomer_id())){
                s.setCustomer_name(username.getText());
                s.setCoach_id(assignedcoachId.getText());
                s.plan.setChoice(plan.getText());
                s.plan.setStart_date(startdate.getText());
                s.plan.setNumber_of_months(Integer.parseInt(noMonths.getText()));
                s.plan.setDays_per_week(Integer.parseInt(daysperweek.getText()));
                s.plan.setPlan_price(Double.parseDouble(price.getText()));
            }
        }

        for(Customer c : MainApplication.customerArrayList){
            System.out.println(c.getUser_name());
            System.out.println(c.getId());
            System.out.println(c.getGender());
        }

    }
    @FXML
    public void DeleteCustomer(ActionEvent event) throws IOException {
        username.setText("");
        password.setText("");
        phonenumber.setText("");
        email.setText("");
        address.setText("");
        gender.setText("");
        inbodydate.setText("");
        mass.setText("");
        bodyfat.setText("");
        height.setText("");
        minerals.setText("");
        protein.setText("");
        bodyweight.setText("");
        bodywater.setText("");
        plan.setText("");
        startdate.setText("");
        noMonths.setText("");
        daysperweek.setText("");
        price.setText("");
        assignedcoachId.setText("");
        String customerIdToRemove = id.getText().trim();
        boolean customerFound = false;
        Iterator<Customer> iterator = MainApplication.return_customerList().iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId().equals(customerIdToRemove)) {
                iterator.remove();
                customerFound=true;
            }
        }    Iterator<InBody> inBodyIterator = MainApplication.InBodyList.iterator();
        while (inBodyIterator.hasNext()) {
            InBody inBodyData = inBodyIterator.next();
            if (customerIdToRemove.equals(inBodyData.getCustomer_id())) {
                inBodyIterator.remove();
                System.out.println("InBody data removed");
                break;
            }
        }
        Iterator<Subscription> subscriptionIterator = MainApplication.subscriptionArrayList.iterator();
        while (subscriptionIterator.hasNext()) {
            Subscription subscriptionData = subscriptionIterator.next();
            if (customerIdToRemove.equals(subscriptionData.getCustomer_id())) {
                subscriptionIterator.remove();
                System.out.println("Subscription data removed");
                break;
            }
        }
        if (!customerFound) {
            System.out.println("Customer with ID " + customerIdToRemove + " not found");
            MainApplication.showAlert("Customer with ID " + customerIdToRemove + " not found");
        } else {
            System.out.println("Customer with ID " + customerIdToRemove + " deleted successfully");
        }
    }
}




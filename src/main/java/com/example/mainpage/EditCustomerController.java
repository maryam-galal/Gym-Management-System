package com.example.mainpage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Iterator;

public class EditCustomerController {

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
                for(String [] s:MainApplication.InBody_Data){
                    if(id.getText().equals(s[0].trim())) {
                        inbodydate.setText(s[1].trim());
                        mass.setText(s[2].trim());
                        bodyfat.setText(s[3].trim());
                        height.setText(s[4].trim());
                        minerals.setText(s[5].trim());
                        protein.setText(s[6].trim());
                        bodyweight.setText(s[7].trim());
                        bodywater.setText(s[8].trim());
                    }}
                for(String [] s:MainApplication.Subscription_Data){
                    if(id.getText().equals(s[0].trim())) {
                        assignedcoachId.setText(s[1].trim());
                        plan.setText(s[3].trim());
                        startdate.setText(s[4].trim());
                        noMonths.setText(s[5].trim());
                        daysperweek.setText(s[6].trim());
                        price.setText(s[7]);
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
    } for(String [] s:MainApplication.InBody_Data){
            if(id.getText().equals(s[0].trim())) {
                s[1]=inbodydate.getText();
                s[2]= mass.getText();
                s[3]= bodyfat.getText();
                s[4]=height.getText();
                s[5]=minerals.getText();
                s[6]=protein.getText();
                s[7]=bodyweight.getText();
                s[8]=bodywater.getText();
                System.out.println("in");
            }}
        for(String [] s:MainApplication.Subscription_Data){
            if(id.getText().equals(s[0].trim())) {
               s[1]= assignedcoachId.getText();
                s[3]=plan.getText();
                s[4]=startdate.getText();
                s[5]=noMonths.getText();
                s[6]=daysperweek.getText();
                s[7]=price.getText();
                System.out.println("sub");
            }
        }
        for(Customer c : MainApplication.customerArrayList){
            System.out.println(c.getUser_name());
            System.out.println(c.getId());
            System.out.println(c.getGender());
        }
        Files.Load_Subscription();
        Files.Load_InBody();

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
        }// Remove the corresponding InBody data
        Iterator<String[]> inBodyIterator = MainApplication.InBody_Data.iterator();
        while (inBodyIterator.hasNext()) {
            String[] inBodyData = inBodyIterator.next();
            if (customerIdToRemove.equals(inBodyData[0].trim())) {
                inBodyIterator.remove();
                System.out.println("InBody data removed");
                break;
            }
        }

        // Remove the corresponding Subscription data
        Iterator<String[]> subscriptionIterator = MainApplication.Subscription_Data.iterator();
        while (subscriptionIterator.hasNext()) {
            String[] subscriptionData = subscriptionIterator.next();
            if (customerIdToRemove.equals(subscriptionData[0].trim())) {
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
        Files.Load_Subscription();
        Files.Load_InBody();
    }


}




package com.example.mainpage.exceptions.signupExceptions;
import com.example.mainpage.MainApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class signUpManager {
    MainApplication signInApplication = new MainApplication();
    public boolean validUsername(String username,String role) throws UsernameAlreadyExistsException {
        for (String[] data : signInApplication.return_userList()) {
            if (data.length >= 8) {
                String usernameFromList = data[1].trim();
                String userRole = data[7].trim();
                if (username.equals(usernameFromList) && role.equals(userRole)) {
                    throw new UsernameAlreadyExistsException("Username already exists" );
                }
            }
        }
        // Username is unique, return true
        return true;
    }
    public boolean validPhoneNumber(String PhoneNumber,String role) throws PhoneNumberException {
        if (PhoneNumber.length() != 11) {
            throw new PhoneNumberException("Invalid phone number");
        }
        if(!PhoneNumber.matches("\\d+")){
            throw new PhoneNumberException("phone number must contain digits only");
        }
        for (String[] data : signInApplication.return_userList()) {
            if (data.length >= 8) {
                String phoneNumberFromList = data[3].trim();
                String userRole = data[7].trim();
                if (PhoneNumber.equals(phoneNumberFromList)&& role.equals(userRole)) {
                    throw new PhoneNumberException("Phone number already exists" );
                }
            }
        }
        // Username is unique, return true
        return true;
    }
    public void validateFields(String username, String password, String phoneNumber, String email, String address, String gender) throws EmptyFieldException {
        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() ||
                email.isEmpty() || address.isEmpty() || gender == null) {
            throw new EmptyFieldException("Please fill in all fields.");
        }
    }
    public boolean validPassword(String password) throws InvalidPasswordException {
        // at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        }

        // at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }

        // at least one digit
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }

        // no other symbols & length at least 8
        if (!password.matches("[a-zA-Z0-9]{8,}")) {
            throw new InvalidPasswordException("Password must not contain symbols and must have a length of at least 8.");
        }

        // check if the password is already in use
        for (String[] data : signInApplication.return_userList()) {
            if (data.length >= 8) {
                String passwordFromList = data[2].trim();
                if (password.equals(passwordFromList)) {
                    throw new InvalidPasswordException("Password is already in use.");
                }
            }
        }

        return true;
    }
    public boolean isValidEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+@(gmail|mail|yahoo|email|outlook)\\.com$";

        /*^[a-zA-Z0-9_+&*-]+: This part specifies that the email address must start with one or more alphanumeric characters,
         underscores, plus signs, ampersands, asterisks, or hyphens.
         @: This specifies the "@" symbol.
         (gmail|mail|yahoo): This is a group that matches either "gmail," "mail," or "yahoo."
         \\.com: This ensures that the email address must end with ".com."*/
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new InvalidEmailException("Wrong Email format.");
        }
        return true;
    }

    public boolean validWorkingHours(Integer start, Integer end) throws WorkingHoursException {
        if((end-start)>10){
            throw new WorkingHoursException("Working hours can't be more than 10");
        }
        return true;
    }
}

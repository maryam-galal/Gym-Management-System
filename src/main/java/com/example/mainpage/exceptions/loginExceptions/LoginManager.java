package com.example.mainpage.exceptions.loginExceptions;
import com.example.mainpage.exceptions.signupExceptions.EmptyFieldException;
import com.example.mainpage.MainApplication;

public class LoginManager {
    MainApplication login_Application = new MainApplication();

    public boolean validateFields(String username, String password) throws EmptyFieldException {
        if (username.isEmpty()) {
            throw new EmptyFieldException("Please enter a username.");
        }
        if (password.isEmpty()) {
            throw new EmptyFieldException("Please enter a password.");
        }
        return true;
    }

    public String isValidUser(String username, String password) throws IncorrectUsernameException, IncorrectPasswordException {
        boolean usernameFound = false;
        boolean passwordMatched = false;
        String userType = null;
        if(username.equals("admin") && password.equals("admin")){
            usernameFound = true;
            passwordMatched = true;
            userType = "admin";
            return userType;
        }
        for (String[] data : login_Application.return_userList()) {
            if (data.length >= 8) {
                String usernameFromList = data[1].trim();
                String passwordFromList = data[2].trim();
                userType = data[7].trim();
                if (username.equals(usernameFromList)) {
                    usernameFound = true;
                    if (password.equals(passwordFromList)) {
                        passwordMatched = true;
                    }
                    break;
                }
            }
        }
//        for (String[] data : login_Application.return_userList()) {
//            if (data.length >= 8) {
//                String usernameFromList = data[1].trim();
//                String passwordFromList = data[2].trim();
//                userType = data[7].trim();
//                if (username.equals(usernameFromList)) {
//                    usernameFound = true;
//                    if (password.equals(passwordFromList)) {
//                        passwordMatched = true;
//                    }
//                    break;
//                }
//            }
        //}

        if (!usernameFound) {
            throw new IncorrectUsernameException();
        }
        if (!passwordMatched) {
            throw new IncorrectPasswordException();
        }
        return userType;
    }
}

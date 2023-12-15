package com.example.mainpage.exceptions.loginExceptions;

public class IncorrectUsernameException extends Exception {
    public IncorrectUsernameException() {
        super("User not found. Please check your username and try again.");
    }
}

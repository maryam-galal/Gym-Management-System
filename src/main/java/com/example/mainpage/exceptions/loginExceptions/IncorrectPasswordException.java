package com.example.mainpage.exceptions.loginExceptions;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException() {
        super("Incorrect password. Please check your password and try again.");
    }
}

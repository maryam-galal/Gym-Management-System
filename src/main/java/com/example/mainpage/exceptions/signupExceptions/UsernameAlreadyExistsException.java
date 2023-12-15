package com.example.mainpage.exceptions.signupExceptions;

public class UsernameAlreadyExistsException extends Exception{
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}

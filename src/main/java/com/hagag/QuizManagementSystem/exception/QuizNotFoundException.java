package com.hagag.QuizManagementSystem.exception;

public class QuizNotFoundException extends RuntimeException{
    public QuizNotFoundException(String message) {
        super(message);
    }
}

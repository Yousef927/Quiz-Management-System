package com.hagag.QuizManagementSystem.exception;

public class QuestionAlreadyExistException extends  RuntimeException{
    public QuestionAlreadyExistException(String message) {
        super(message);
    }
}

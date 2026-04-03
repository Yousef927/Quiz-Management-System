package com.hagag.QuizManagementSystem.exception;

import com.hagag.QuizManagementSystem.DTOS.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({QuizNotFoundException.class , QuestionNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleQuizNotFound(Exception ex) {

        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(QuizSubmissionException.class)
    public ResponseEntity<ErrorResponse> handleQuizSubmission(QuizSubmissionException ex) {

        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(QuestionAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleQuestionAlreadyExist(QuestionAlreadyExistException ex) {

        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.CONFLICT);
        return new ResponseEntity<>(errorResponse , HttpStatus.CONFLICT);
    }
}

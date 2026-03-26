package com.hagag.QuizManagementSystem.services;

import com.hagag.QuizManagementSystem.DAOS.QuestionRepository;
import com.hagag.QuizManagementSystem.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll() , HttpStatus.OK);
    }
}

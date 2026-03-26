package com.hagag.QuizManagementSystem.controllers;

import com.hagag.QuizManagementSystem.DAOS.QuestionRepository;
import com.hagag.QuizManagementSystem.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/getQuestions")
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }


}

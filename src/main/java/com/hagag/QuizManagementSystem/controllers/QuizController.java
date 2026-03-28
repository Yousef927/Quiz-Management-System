package com.hagag.QuizManagementSystem.controllers;

import com.hagag.QuizManagementSystem.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String quizTitle , @RequestParam Integer numberOfQuestions) {
        return quizService.createQuiz(quizTitle , numberOfQuestions);

    }
}

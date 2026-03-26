package com.hagag.QuizManagementSystem.controllers;

import com.hagag.QuizManagementSystem.DAOS.QuestionRepository;
import com.hagag.QuizManagementSystem.DTOS.QuestionRequestDTO;
import com.hagag.QuizManagementSystem.entities.Question;
import com.hagag.QuizManagementSystem.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionService questionService;

    @GetMapping("/getQuestions")
    public ResponseEntity<List<Question>> getQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionRequestDTO question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

    @PutMapping("/updateQuestion/{id}")
    public  ResponseEntity<String> updateQuestion(@PathVariable Integer id , @RequestBody QuestionRequestDTO questionRequest) {
        return questionService.updateQuestion(id , questionRequest);
    }


}

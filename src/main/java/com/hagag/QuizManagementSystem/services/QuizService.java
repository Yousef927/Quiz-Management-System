package com.hagag.QuizManagementSystem.services;

import com.hagag.QuizManagementSystem.DAOS.QuestionRepository;
import com.hagag.QuizManagementSystem.DAOS.QuizRepository;
import com.hagag.QuizManagementSystem.entities.Question;
import com.hagag.QuizManagementSystem.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizService {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuizRepository quizRepository;


    public ResponseEntity<String> createQuiz(String quizTitle , Integer numberOfQuestions) {

        Quiz quiz = new Quiz();

        List<Question> questions = questionRepository.findAll();
        if (numberOfQuestions > questions.size()) {
            return new ResponseEntity<>("Not enough questions in the database to create the quiz" , HttpStatus.BAD_REQUEST);
        }
        Collections.shuffle(questions);
        List<Question> selectedQuestions = questions.subList(0 , numberOfQuestions);

        quiz.setTitle(quizTitle);
        quiz.setQuestions(selectedQuestions);

        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz created successfully" , HttpStatus.CREATED);




    }
}

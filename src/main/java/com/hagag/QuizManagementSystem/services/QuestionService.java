package com.hagag.QuizManagementSystem.services;

import com.hagag.QuizManagementSystem.DAOS.QuestionRepository;
import com.hagag.QuizManagementSystem.DTOS.QuestionRequestDTO;
import com.hagag.QuizManagementSystem.DTOS.QuestionResponseDTO;
import com.hagag.QuizManagementSystem.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<String> addQuestion(QuestionRequestDTO questionRequest) {
        Question question = new Question();
        question.setQuestionTitle(questionRequest.getQuestionTitle());
        question.setOption1(questionRequest.getOption1());
        question.setOption2((questionRequest.getOption2()));
        question.setOption3(questionRequest.getOption3());
        question.setOption4(questionRequest.getOption4());
        question.setRightAnswer(questionRequest.getRightAnswer());
        question.setDifficulty((questionRequest.getDifficulty()));
        question.setCategory(questionRequest.getCategory());


        questionRepository.save(question);
        return new ResponseEntity<>("Question added successfully" , HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        if(!questionRepository.existsById(id)) {
            return new ResponseEntity<>("Question not found" , HttpStatus.NOT_FOUND);
        }
        Question question = questionRepository.findById(id).get();
        questionRepository.delete(question);
        return new ResponseEntity<>("Question deleted successfully" , HttpStatus.OK);
    }

    public ResponseEntity<String> updateQuestion(Integer id, QuestionRequestDTO questionRequest) {
        if(!questionRepository.existsById(id)) {
            return new ResponseEntity<>("Question not found" , HttpStatus.NOT_FOUND);
        }
        Question question = questionRepository.findById(id).get();
        question.setQuestionTitle(questionRequest.getQuestionTitle());
        question.setOption1(questionRequest.getOption1());
        question.setOption2((questionRequest.getOption2()));
        question.setOption3(questionRequest.getOption3());
        question.setOption4(questionRequest.getOption4());
        question.setRightAnswer(questionRequest.getRightAnswer());
        question.setDifficulty((questionRequest.getDifficulty()));
        question.setCategory(questionRequest.getCategory());

        questionRepository.save(question);
        return new ResponseEntity<>("Question updated successfully" , HttpStatus.OK);
    }
}

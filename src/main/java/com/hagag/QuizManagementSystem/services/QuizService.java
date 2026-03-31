package com.hagag.QuizManagementSystem.services;

import com.hagag.QuizManagementSystem.DAOS.QuestionRepository;
import com.hagag.QuizManagementSystem.DAOS.QuizRepository;
import com.hagag.QuizManagementSystem.DTOS.QuestionResponseDTO;
import com.hagag.QuizManagementSystem.DTOS.QuizResultDTO;
import com.hagag.QuizManagementSystem.entities.Question;
import com.hagag.QuizManagementSystem.entities.Quiz;
import com.hagag.QuizManagementSystem.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
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

    public ResponseEntity<List<QuestionResponseDTO>> getQuizQuestions(Integer id) {
        if (!quizRepository.existsById(id)) {
            return null;
        }
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> quizQuestions = quiz.getQuestions();
        List<QuestionResponseDTO> questionResponseDTOS = new ArrayList<>();

        for(Question question : quizQuestions) {
            questionResponseDTOS.add(new QuestionResponseDTO(
                    question.getId(),
                    question.getQuestionTitle(),
                    question.getOption1(),
                    question.getOption2(),
                    question.getOption3(),
                    question.getOption4()));
        }
        return new ResponseEntity<>(questionResponseDTOS , HttpStatus.OK);

    }

    public ResponseEntity<QuizResultDTO> submitQuiz(Integer id, List<Response> responses) {

        if (!quizRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> quizQuestions = quiz.getQuestions();
        QuizResultDTO quizResultDTO = new QuizResultDTO();

        int score = 0;
        for(Response response : responses) {
            for(Question question : quizQuestions) {
                if (question.getId().equals(response.getQuestionId())) {

                    if (question.getRightAnswer().trim().equalsIgnoreCase(response.getAnswer().trim())) {
                        score++;
                    }
                    break;
                }
            }
        }
        quizResultDTO.setStudentScore(score);
        quizResultDTO.setQuizTotalScore(quizQuestions.size());
        return new ResponseEntity<>(  quizResultDTO , HttpStatus.OK);
    }
}

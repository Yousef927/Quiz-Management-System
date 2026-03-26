package com.hagag.QuizManagementSystem.DAOS;

import com.hagag.QuizManagementSystem.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question , Integer> {


}

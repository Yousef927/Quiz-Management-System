package com.hagag.QuizManagementSystem.DAOS;

import com.hagag.QuizManagementSystem.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question , Integer> {


}

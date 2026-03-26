package com.hagag.QuizManagementSystem.DAOS;

import com.hagag.QuizManagementSystem.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}

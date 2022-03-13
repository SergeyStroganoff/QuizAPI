package com.stroganov.quizapi.repository;

import com.stroganov.quizapi.models.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findQuizByStatus();

}

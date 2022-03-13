package com.stroganov.quizapi.repository;

import com.stroganov.quizapi.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

package com.stroganov.quizapi.repository;

import com.stroganov.quizapi.models.entities.Question;
import com.stroganov.quizapi.models.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findQuestionsByQuiz(Quiz quiz);
}

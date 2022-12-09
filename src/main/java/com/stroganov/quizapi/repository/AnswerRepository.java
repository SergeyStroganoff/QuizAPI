package com.stroganov.quizapi.repository;

import com.stroganov.quizapi.models.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("select a from Answer a where a.user.id = ?2 and a.question.quiz.id = ?1")
    List<Answer> findAnswersByUserAndQuestionQuiz(Long quizId, Long userId);
}

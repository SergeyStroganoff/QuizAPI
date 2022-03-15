package com.stroganov.quizapi.repository;

import com.stroganov.quizapi.models.dto.AnswerDto;
import com.stroganov.quizapi.models.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("select a from Answer a JOIN a.question q  JOIN q.quiz z where z.id = ?1 and a.user.id = ?2")
    List<AnswerDto> findAllByQuestionAndUser(Long quizId, Long userId);
}

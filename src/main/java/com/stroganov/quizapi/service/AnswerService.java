package com.stroganov.quizapi.service;

import com.stroganov.quizapi.exceptions.AnswerServiceException;
import com.stroganov.quizapi.models.dto.AnswerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    void save(AnswerDto answerDto) throws AnswerServiceException;

    void delete(Long answerId) throws AnswerServiceException;

    List<AnswerDto> findAllByUserAndQuiz(String quizId, String userId) throws AnswerServiceException;

}

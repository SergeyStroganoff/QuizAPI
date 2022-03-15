package com.stroganov.quizapi.service;

import com.stroganov.quizapi.exceptions.AnswerServiceException;
import com.stroganov.quizapi.exceptions.QuestionServiceException;
import com.stroganov.quizapi.models.dto.AnswerDto;
import com.stroganov.quizapi.models.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {

    void save(AnswerDto answerDto) throws QuestionServiceException, AnswerServiceException;

    void delete(Long answerId) throws QuestionServiceException, AnswerServiceException;

    List<AnswerDto> findAllByUserAndQuiz(Long quizId, Long userId) throws QuestionServiceException, AnswerServiceException;

}

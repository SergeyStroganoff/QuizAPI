package com.stroganov.quizapi.service;

import com.stroganov.quizapi.exceptions.QuestionServiceException;
import com.stroganov.quizapi.models.dto.QuestionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    void save(QuestionDto questionDto) throws QuestionServiceException;

    void change(QuestionDto questionDto, String id) throws QuestionServiceException;

    void delete(Long questionId) throws QuestionServiceException;

    List<QuestionDto> findAllQuestionByQuiz(Long quizId) throws QuestionServiceException;

}

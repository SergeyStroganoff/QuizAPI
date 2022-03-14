package com.stroganov.quizapi.service;

import com.stroganov.quizapi.exceptions.QuizServiceException;
import com.stroganov.quizapi.models.dto.QuizDto;
import org.springframework.stereotype.Service;

@Service
public interface QuizService {
    void save(QuizDto quizDto) throws QuizServiceException;

    void change(QuizDto quizDto, String id) throws QuizServiceException;

    void delete(Long quizId) throws QuizServiceException;

}

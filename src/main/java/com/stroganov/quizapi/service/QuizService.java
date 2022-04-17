package com.stroganov.quizapi.service;

import com.stroganov.quizapi.exceptions.QuizServiceException;
import com.stroganov.quizapi.models.dto.QuizDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    void save(QuizDto quizDto) throws QuizServiceException;

    void change(QuizDto quizDto, String id) throws QuizServiceException;

    void delete(Long quizId) throws QuizServiceException;

    List<QuizDto> findQuizByStatus(boolean status) throws QuizServiceException;

    List<QuizDto> findQuizByUserId(long userId) throws QuizServiceException;
}

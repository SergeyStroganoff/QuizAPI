package com.stroganov.quizapi.service;

import com.stroganov.quizapi.exceptions.QuestionTypeServiceException;
import com.stroganov.quizapi.models.dto.QuestionTypeDto;
import org.springframework.stereotype.Service;

@Service
public interface QuestionTypeService {

    void save(QuestionTypeDto questionTypeDto) throws QuestionTypeServiceException;

    void delete(Long id) throws QuestionTypeServiceException;
}

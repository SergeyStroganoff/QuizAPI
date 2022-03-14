package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.QuestionTypeServiceException;
import com.stroganov.quizapi.models.dto.QuestionTypeDto;
import com.stroganov.quizapi.models.entities.QuestionType;
import com.stroganov.quizapi.repository.QuestionTypeRepository;
import com.stroganov.quizapi.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionTypeServiceImpl implements QuestionTypeService {

    public static final String QUESTION_TYPE_WAS_NOT_FOUND = "QuestionType was not found";
    QuestionTypeRepository questionTypeRepository;
    Logger logger = Logger.getLogger(QuestionTypeServiceImpl.class);

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public QuestionTypeServiceImpl(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public void save(QuestionTypeDto questionTypeDto) throws QuestionTypeServiceException {
        QuestionType questionType = modelMapper.map(questionTypeDto, QuestionType.class);
        try {
            questionTypeRepository.save(questionType);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new QuestionTypeServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws QuestionTypeServiceException {
        Optional<QuestionType> questionTypeOptional = questionTypeRepository.findById(id);
        if (questionTypeOptional.isPresent()) {
            try {
                questionTypeRepository.delete(questionTypeOptional.get());
            } catch (Exception e) {
                logger.error(e.getMessage());
                throw new QuestionTypeServiceException(e.getMessage());
            }
        } else {
            throw new QuestionTypeServiceException(QUESTION_TYPE_WAS_NOT_FOUND);
        }
    }
}

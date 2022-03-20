package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.QuestionTypeServiceException;
import com.stroganov.quizapi.models.dto.QuestionTypeDto;
import com.stroganov.quizapi.models.entities.QuestionType;
import com.stroganov.quizapi.repository.QuestionTypeRepository;
import com.stroganov.quizapi.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class QuestionTypeServiceImpl implements QuestionTypeService {

    public static final String QUESTION_TYPE_WAS_NOT_FOUND = "QuestionType was not found";
    private final QuestionTypeRepository questionTypeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public QuestionTypeServiceImpl(QuestionTypeRepository questionTypeRepository, ModelMapper modelMapper) {
        this.questionTypeRepository = questionTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(QuestionTypeDto questionTypeDto) throws QuestionTypeServiceException {
        QuestionType questionType = modelMapper.map(questionTypeDto, QuestionType.class);
        try {
            questionTypeRepository.save(questionType);
        } catch (Exception e) {
            log.error(e.getMessage());
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
                log.error(e.getMessage());
                throw new QuestionTypeServiceException(e.getMessage());
            }
        } else {
            throw new QuestionTypeServiceException(QUESTION_TYPE_WAS_NOT_FOUND);
        }
    }
}

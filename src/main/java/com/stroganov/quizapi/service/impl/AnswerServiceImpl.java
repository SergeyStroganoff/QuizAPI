package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.AnswerServiceException;
import com.stroganov.quizapi.models.dto.AnswerDto;
import com.stroganov.quizapi.models.entities.Answer;
import com.stroganov.quizapi.repository.AnswerRepository;
import com.stroganov.quizapi.service.AnswerService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    public static final String ANSWER_WAS_NOT_FOUND = "Answer was not found";
    @Autowired
    ModelMapper modelMapper;
    AnswerRepository answerRepository;

    Logger logger = Logger.getLogger(AnswerServiceImpl.class);

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void save(AnswerDto answerDto) throws AnswerServiceException {
        Answer answer = modelMapper.map(answerDto, Answer.class);
        try {
            answerRepository.save(answer);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new AnswerServiceException(e);
        }
    }

    @Override
    public void delete(Long answerId) throws AnswerServiceException {
        Answer answer = answerRepository.getById(answerId);
        if (answer != null) {
            answerRepository.delete(answer);
        } else {
            throw new AnswerServiceException(ANSWER_WAS_NOT_FOUND);
        }
    }

    @Override
    public List<AnswerDto> findAllByUserAndQuiz(Long quizId, Long userId) throws AnswerServiceException {
        try {
            return answerRepository.findAllByQuestionAndUser(quizId, userId);
        } catch (Exception e) {
            throw new AnswerServiceException(e);
        }
    }
}

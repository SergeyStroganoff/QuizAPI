package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.AnswerServiceException;
import com.stroganov.quizapi.models.dto.AnswerDto;
import com.stroganov.quizapi.models.entities.Answer;
import com.stroganov.quizapi.repository.AnswerRepository;
import com.stroganov.quizapi.service.AnswerService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
            logger.debug(ANSWER_WAS_NOT_FOUND + " " + answerId);
            throw new AnswerServiceException(ANSWER_WAS_NOT_FOUND);
        }
    }

    @Override
    public List<AnswerDto> findAllByUserAndQuiz(String quizId, String userId) throws AnswerServiceException {
        try {
            List<Answer> answerList = answerRepository.findAnswersByUserAndQuestionQuiz(Long.parseLong(quizId), Long.parseLong(userId));
            return modelMapper.map(answerList, new TypeToken<List<AnswerDto>>() {
            }.getType());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new AnswerServiceException(e);
        }
    }
}

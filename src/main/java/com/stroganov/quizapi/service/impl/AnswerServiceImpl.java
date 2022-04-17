package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.AnswerServiceException;
import com.stroganov.quizapi.models.dto.AnswerDto;
import com.stroganov.quizapi.models.entities.Answer;
import com.stroganov.quizapi.repository.AnswerRepository;
import com.stroganov.quizapi.service.AnswerService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AnswerServiceImpl implements AnswerService {
    public static final String ANSWER_WAS_NOT_FOUND = "Answer was not found";
    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(ModelMapper modelMapper, AnswerRepository answerRepository) {
        this.modelMapper = modelMapper;
        this.answerRepository = answerRepository;
    }

    @Override
    public void save(AnswerDto answerDto) throws AnswerServiceException {
        Answer answer = modelMapper.map(answerDto, Answer.class);
        try {
            answerRepository.save(answer);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AnswerServiceException(e);
        }
    }

    @Override
    public void delete(Long answerId) throws AnswerServiceException {
        Optional<Answer> answer = answerRepository.findById(answerId);
        if (answer.isPresent()) {
            answerRepository.delete(answer.get());
        } else {
            log.debug(ANSWER_WAS_NOT_FOUND + " " + answerId);
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
            log.error(e.getMessage());
            throw new AnswerServiceException(e);
        }
    }
}

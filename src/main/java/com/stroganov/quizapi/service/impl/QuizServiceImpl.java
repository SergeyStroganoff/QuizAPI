package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.QuizServiceException;
import com.stroganov.quizapi.models.dto.QuizDto;
import com.stroganov.quizapi.models.entities.Quiz;
import com.stroganov.quizapi.models.entities.User;
import com.stroganov.quizapi.repository.QuizRepository;
import com.stroganov.quizapi.repository.UserRepository;
import com.stroganov.quizapi.service.QuizService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(QuizDto quizDto) throws QuizServiceException {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        try {
            quizRepository.save(quiz);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new QuizServiceException(e.getMessage());
        }
    }

    @Override
    public void change(QuizDto quizDto, String id) throws QuizServiceException {
        try {
            Optional<Quiz> quizOptional = quizRepository.findById(Long.parseLong(id));
            if (quizOptional.isEmpty()) {
                Quiz newQuiz = modelMapper.map(quizDto, Quiz.class);
                quizRepository.save(newQuiz);
            } else {
                Quiz quiz = quizOptional.get();
                Date startDateQuiz = quiz.getStartDate();
                quiz = modelMapper.map(quizDto, Quiz.class);
                quiz.setStartDate(startDateQuiz);
                quizRepository.save(quiz);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new QuizServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long quizId) throws QuizServiceException {
        try {
            quizRepository.deleteById(quizId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new QuizServiceException(e.getMessage());
        }
    }

    @Override
    public List<QuizDto> findQuizByStatus(boolean status) throws QuizServiceException {
        try {
            List<Quiz> quizList = quizRepository.findQuizByStatus(status);
            return modelMapper.map(quizList, new TypeToken<List<QuizDto>>() {
            }.getType());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new QuizServiceException(e.getMessage());
        }
    }

    @Override
    public List<QuizDto> findQuizByUserId(long userId) throws QuizServiceException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            String message = "No such user" + userId;
            log.info(message);
            throw new QuizServiceException(message);
        }
        List<Quiz> quizList = userOptional.get().getQuizLIst();
        return modelMapper.map(quizList, new TypeToken<List<QuizDto>>() {
        }.getType());
    }
}

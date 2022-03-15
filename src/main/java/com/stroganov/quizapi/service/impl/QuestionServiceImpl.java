package com.stroganov.quizapi.service.impl;

import com.stroganov.quizapi.exceptions.QuestionServiceException;
import com.stroganov.quizapi.models.dto.QuestionDto;
import com.stroganov.quizapi.models.dto.QuizDto;
import com.stroganov.quizapi.models.entities.Question;
import com.stroganov.quizapi.models.entities.QuestionType;
import com.stroganov.quizapi.models.entities.Quiz;
import com.stroganov.quizapi.repository.QuestionRepository;
import com.stroganov.quizapi.repository.QuizRepository;
import com.stroganov.quizapi.service.QuestionService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    public static final String QUESTION_NOT_FOUND = "Question not found";
    @Autowired
    ModelMapper modelMapper;
    QuestionRepository questionRepository;
    QuizRepository quizRepository;
    Logger logger = Logger.getLogger(QuestionServiceImpl.class);

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public void save(QuestionDto questionDto) throws QuestionServiceException {
        Question question = modelMapper.map(questionDto, Question.class);
        try {
            questionRepository.save(question);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new QuestionServiceException(e.getMessage());
        }
    }

    @Override
    public void change(QuestionDto questionDto, String id) throws QuestionServiceException {
        try {
            Question question = questionRepository.getById(Long.parseLong(id));
            if (question == null) {
                questionRepository.save(modelMapper.map(questionDto, Question.class));
            } else {
                question.setQuiz(modelMapper.map(questionDto.getQuiz(), Quiz.class));
                question.setText(questionDto.getText());
                question.setType(modelMapper.map(questionDto.getType(), QuestionType.class));
                questionRepository.save(question);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new QuestionServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long questionId) throws QuestionServiceException {
        try {
            Optional<Question> question = questionRepository.findById(questionId);
            if (question.isPresent()) {
                questionRepository.delete(question.get());
            } else {
                throw new QuestionServiceException(QUESTION_NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new QuestionServiceException(e.getMessage());
        }
    }

    @Override
    public List<QuestionDto> findAllQuestionByQuiz(Long quizId) throws QuestionServiceException {
        Quiz quiz = quizRepository.getById(quizId);
        try {
            List<Question> questionList = questionRepository.findQuestionsByQuiz(quiz);
            return modelMapper.map(questionList, new TypeToken<List<QuizDto>>() {
            }.getType());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new QuestionServiceException(e.getMessage());
        }
    }

}
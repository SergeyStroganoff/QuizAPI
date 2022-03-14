package com.stroganov.quizapi.handlers;

import com.stroganov.quizapi.exceptions.QuizServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(QuizServiceException.class)
    public ResponseEntity<String> handleAuthorServiceException(QuizServiceException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

package com.stroganov.quizapi.exceptions;

public class QuestionServiceException extends Exception {

    public QuestionServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionServiceException(String message) {
        super(message);
    }
}

package com.stroganov.quizapi.exceptions;

public class AnswerServiceException extends Exception {
    public AnswerServiceException(String message) {
        super(message);
    }

    public AnswerServiceException(Throwable cause) {
        super(cause);
    }
}

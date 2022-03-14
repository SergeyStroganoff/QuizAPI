package com.stroganov.quizapi.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto implements Serializable {

    private UserDto user;

    private QuestionDto question;
}

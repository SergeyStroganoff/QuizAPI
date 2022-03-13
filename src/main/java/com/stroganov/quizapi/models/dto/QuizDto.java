package com.stroganov.quizapi.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class QuizDto implements Serializable {

    private Date startDate;

    private Date endDate;

    private String description;

    private boolean status;
}

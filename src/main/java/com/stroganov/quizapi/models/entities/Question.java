package com.stroganov.quizapi.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question implements Serializable {

    @ManyToOne
    @JoinColumn(name = "type_id")
    QuestionType type;
    @ManyToOne
    @JoinColumn(name = "id")
    Quiz quiz;
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "text")
    private String text;

}

package com.stroganov.quizapi.models.entities;

import javax.persistence.*;
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
@Table(name = ("question"))
public class Question implements Serializable {

    @Id
    @Column(name = "id", nullable = false, insertable=false,updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    QuestionType type;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    @Column(name = "text")
    private String text;

}

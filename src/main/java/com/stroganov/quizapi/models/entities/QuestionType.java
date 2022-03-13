package com.stroganov.quizapi.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "qustion_type")
public class QuestionType implements Serializable {

    @Id
    @Column(name = "type_id", nullable = false)
    private Long type_id;

    @Column(name = "string")
    private String string;
}

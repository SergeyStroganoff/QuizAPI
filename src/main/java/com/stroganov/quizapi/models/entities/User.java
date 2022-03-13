package com.stroganov.quizapi.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ("user"))
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alias")
    private String alias;

    //  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //  @JoinTable(name = "user_quiz", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    //  List<Quiz> quizLIst;
}
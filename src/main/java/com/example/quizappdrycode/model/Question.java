package com.example.quizappdrycode.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean status;

    private boolean answered;

    @ManyToOne
    private QuestionType questionType;

    @ManyToOne
    private Level level;

    @ManyToOne
    private Quiz quiz;
}

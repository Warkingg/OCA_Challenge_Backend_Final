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

    @ManyToOne
    private QuestionType questionType;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private Quiz quiz;
}

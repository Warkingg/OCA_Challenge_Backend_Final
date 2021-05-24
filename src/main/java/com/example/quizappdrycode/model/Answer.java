package com.example.quizappdrycode.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isAnswer;

    private boolean selected;

    @ManyToOne
    private Question question;
}

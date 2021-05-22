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

    private boolean correct;

    @ManyToOne
    private Question question;
}

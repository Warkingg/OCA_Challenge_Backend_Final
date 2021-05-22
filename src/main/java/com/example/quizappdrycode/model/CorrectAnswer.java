package com.example.quizappdrycode.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class CorrectAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private Question question;
}

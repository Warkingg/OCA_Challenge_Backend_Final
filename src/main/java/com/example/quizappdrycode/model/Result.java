package com.example.quizappdrycode.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double score;

    @ManyToOne
    private User user;
}
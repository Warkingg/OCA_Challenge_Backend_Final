package com.example.quizappdrycode.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String confirmPassword;

    private String oldPassword;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}

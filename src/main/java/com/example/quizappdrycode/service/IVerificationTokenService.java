package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.VerificationToken;

public interface IVerificationTokenService {
    VerificationToken findByToken(String token);

    void save(VerificationToken token);
}

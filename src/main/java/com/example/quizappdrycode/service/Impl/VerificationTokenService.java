package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.VerificationToken;
import com.example.quizappdrycode.repository.IVerificationTokenRepository;
import com.example.quizappdrycode.service.IVerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService implements IVerificationTokenService {
    @Autowired
    private IVerificationTokenRepository verificationTokenRepository;

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    @Override
    public void save(VerificationToken token) {
        verificationTokenRepository.save(token);
    }
}

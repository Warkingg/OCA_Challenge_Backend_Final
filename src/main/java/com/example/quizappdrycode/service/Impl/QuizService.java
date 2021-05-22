package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.Quiz;
import com.example.quizappdrycode.repository.IQuizRepository;
import com.example.quizappdrycode.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private IQuizRepository quizRepository;

    @Override
    public Iterable<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void remove(Long id) {
        quizRepository.deleteById(id);
    }
}

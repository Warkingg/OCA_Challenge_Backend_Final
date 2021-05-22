package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.CorrectAnswer;
import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.repository.ICorrectAnswerRepository;
import com.example.quizappdrycode.service.ICorrectAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorrectAnswerService implements ICorrectAnswerService {
    @Autowired
    private ICorrectAnswerRepository correctAnswerRepository;
    @Override
    public Iterable<CorrectAnswer> findAllByQuestion(Question question) {
        return correctAnswerRepository.findAllByQuestion(question);
    }

    @Override
    public Iterable<CorrectAnswer> findAll() {
        return correctAnswerRepository.findAll();
    }

    @Override
    public Optional<CorrectAnswer> findById(Long id) {
        return correctAnswerRepository.findById(id);
    }

    @Override
    public CorrectAnswer save(CorrectAnswer correctAnswer) {
        return correctAnswerRepository.save(correctAnswer);
    }

    @Override
    public void remove(Long id) {
        correctAnswerRepository.deleteById(id);
    }
}

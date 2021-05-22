package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.model.Question;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> findAll(int page, int size);

    Iterable<Question> findAllByLevel(Level level);
}

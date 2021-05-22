package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.Question;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> findAll(int page, int size);
}

package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.Answer;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAll(int page, int size);
}

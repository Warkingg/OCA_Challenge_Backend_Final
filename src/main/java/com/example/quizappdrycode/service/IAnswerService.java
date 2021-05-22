package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.Answer;
import com.example.quizappdrycode.model.Question;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAll(int page, int size);
    Iterable<Answer> findALlAnswerByQuestion(Question question);
}

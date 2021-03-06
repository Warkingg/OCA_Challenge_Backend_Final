package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.CorrectAnswer;
import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.service.Impl.CorrectAnswerService;

public interface ICorrectAnswerService extends IGeneralService<CorrectAnswer> {
    Iterable<CorrectAnswer> findAllByQuestion(Question question);
}

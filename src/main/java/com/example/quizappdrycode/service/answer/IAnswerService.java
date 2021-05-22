package com.example.quizappdrycode.service.answer;

import com.example.quizappdrycode.model.Answer;
import com.example.quizappdrycode.service.IGeneralService;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAll(int page, int size);
}

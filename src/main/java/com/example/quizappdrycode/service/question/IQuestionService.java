package com.example.quizappdrycode.service.question;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.service.IGeneralService;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> findAll(int page, int size);

    Iterable<Question> findAllByLevel(Level level);
}

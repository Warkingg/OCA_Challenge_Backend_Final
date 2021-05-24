package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.Result;
import com.example.quizappdrycode.model.User;

public interface IResultService extends IGeneralService<Result> {
    Iterable<Result> findAllByUser(User user);
}

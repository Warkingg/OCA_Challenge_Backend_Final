package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.History;

public interface IHistoryService extends IGeneralService<History> {
    History findByName(String history);
}

package com.example.quizappdrycode.service.level;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.model.Topic;
import com.example.quizappdrycode.service.IGeneralService;

public interface ILevelService extends IGeneralService<Level> {
    Iterable<Level> findAllByTopic(Topic topic);
}

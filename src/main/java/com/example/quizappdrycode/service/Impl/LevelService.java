package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.model.Topic;
import com.example.quizappdrycode.repository.ILevelRepository;
import com.example.quizappdrycode.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LevelService implements ILevelService {
    @Autowired
    private ILevelRepository levelRepository;

    @Override
    public Iterable<Level> findAll() {
        return levelRepository.findAll();
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levelRepository.findById(id);
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public void remove(Long id) {
        levelRepository.deleteById(id);
    }

//    @Override
//    public Iterable<Level> findAllByTopic(Topic topic) {
//        return levelRepository.findAllByTopic(topic);
//    }

}

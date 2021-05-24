package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.Result;
import com.example.quizappdrycode.model.User;
import com.example.quizappdrycode.repository.IResultRepository;
import com.example.quizappdrycode.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService implements IResultService {
    @Autowired
    private IResultRepository resultRepository;

    @Override
    public Iterable<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    @Override
    public Result save(Result model) {
        return resultRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    public Iterable<Result> findAllByUser(User user) {
        return resultRepository.findAllByUser(user);
    }


}

package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.History;
import com.example.quizappdrycode.repository.IHistoryRepository;
import com.example.quizappdrycode.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class HistoryService implements IHistoryService {
    @Autowired
    private IHistoryRepository historyRepository;
    @Override
    public Iterable<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> findById(Long id) {
        return historyRepository.findById(id);
    }

    @Override
    public History save(History model) {
        return historyRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        historyRepository.deleteById(id);
    }

    @Override
    public History findByName(String history) {
        return historyRepository.findByName(history);
    }
}

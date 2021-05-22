package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.QuestionType;
import com.example.quizappdrycode.repository.IQuestionTypeRepository;
import com.example.quizappdrycode.service.ITypeOfQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {

    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;


    @Override
    public Iterable<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(Long id) {
        return iQuestionTypeRepository.findById(id);
    }

    @Override
    public QuestionType save(QuestionType questionType) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}

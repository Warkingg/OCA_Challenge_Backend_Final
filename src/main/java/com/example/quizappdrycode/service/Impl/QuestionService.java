package com.example.quizappdrycode.service.Impl;

import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.repository.IQuestionRepository;
import com.example.quizappdrycode.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Question> questions = questionRepository.findAll(pageRequest);
        return questions.getContent();
    }

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}

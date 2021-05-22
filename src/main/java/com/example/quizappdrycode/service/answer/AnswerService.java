package com.example.quizappdrycode.service.answer;

import com.example.quizappdrycode.model.Answer;
import com.example.quizappdrycode.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public Iterable<Answer> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Answer> answers = answerRepository.findAll(pageRequest);
        return answers.getContent();
    }

    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer t) {
        return answerRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);
    }
}

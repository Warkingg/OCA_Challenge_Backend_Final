package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.CorrectAnswer;

import com.example.quizappdrycode.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICorrectAnswerRepository extends JpaRepository<CorrectAnswer,Long> {
    Iterable<CorrectAnswer> findAllByQuestion(Question question);
}

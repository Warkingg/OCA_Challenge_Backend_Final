package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Answer;
import com.example.quizappdrycode.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer,Long> {
    Iterable<Answer> getAnswerByQuestion(Question question);
}

package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnswerRepository extends JpaRepository<Answer,Long> {
}

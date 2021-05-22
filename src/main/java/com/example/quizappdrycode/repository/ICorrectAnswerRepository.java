package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.CorrectAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICorrectAnswerRepository extends JpaRepository<CorrectAnswer,Long> {
}

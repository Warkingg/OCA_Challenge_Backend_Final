package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question,Long> {
}

package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}

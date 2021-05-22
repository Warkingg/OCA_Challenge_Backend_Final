package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}

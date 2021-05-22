package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepository extends JpaRepository<Quiz, Long> {
}

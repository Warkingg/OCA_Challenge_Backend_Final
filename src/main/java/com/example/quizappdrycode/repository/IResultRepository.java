package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResultRepository extends JpaRepository<Result, Long> {
}

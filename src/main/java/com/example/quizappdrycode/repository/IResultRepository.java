package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Result;
import com.example.quizappdrycode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result, Long> {
    Iterable<Result> findAllByUser(User user);

}

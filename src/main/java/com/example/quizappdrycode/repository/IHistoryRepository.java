package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History,Long> {
}

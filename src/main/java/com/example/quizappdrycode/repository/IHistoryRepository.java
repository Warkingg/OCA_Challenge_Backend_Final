package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryRepository extends JpaRepository<History,Long> {
    History findByName(String history);
}

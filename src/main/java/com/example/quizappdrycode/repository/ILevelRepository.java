package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelRepository extends JpaRepository<Level, Long> {
//    Iterable<Level> findAllByTopic(Topic topic);
}

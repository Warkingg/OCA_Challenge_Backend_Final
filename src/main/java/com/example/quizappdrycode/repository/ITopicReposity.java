package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicReposity extends JpaRepository<Topic, Long> {
}

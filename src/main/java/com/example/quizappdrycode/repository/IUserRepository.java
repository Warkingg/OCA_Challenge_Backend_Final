package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}

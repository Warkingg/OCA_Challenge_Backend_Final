package com.example.quizappdrycode.repository;

import com.example.quizappdrycode.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

package com.example.quizappdrycode.service;

<<<<<<< HEAD
public interface IGeneralService {
=======
import java.util.Optional;

public interface IGeneralService <T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T model);

    void remove(Long id);

>>>>>>> c4c25c16806bf531b1df1c5df87d4f3123d531c1
}

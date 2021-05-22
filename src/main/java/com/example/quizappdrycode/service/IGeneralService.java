package com.example.quizappdrycode.service;


import java.util.Optional;

public interface IGeneralService <T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T model);

    void remove(Long id);
}

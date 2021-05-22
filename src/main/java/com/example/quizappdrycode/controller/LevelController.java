package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/levels")
public class LevelController {

    @Autowired
    private ILevelService levelService;

    @GetMapping
    public ResponseEntity<Iterable<Level>> getLevels() {
        return new ResponseEntity<>(levelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Level> getLevel(@PathVariable ("id") Long id) {
        Optional<Level> levelOptional = levelService.findById(id);
        return new ResponseEntity<>(levelOptional.get(), HttpStatus.OK);
    }

//    findAllByTopic lỗi như chó
}

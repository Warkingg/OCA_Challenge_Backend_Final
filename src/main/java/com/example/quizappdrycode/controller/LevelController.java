package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.service.ILevelService;
import com.example.quizappdrycode.model.Topic;
import com.example.quizappdrycode.service.ITopicService;
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

    @GetMapping("/GetLevelByTopic/{id}")
    public ResponseEntity<Iterable<Level>> findAllByTopic(@PathVariable("id") Long id) {
        Optional<Topic> topicOptional = topicService.findById(id);
        if (!topicOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Level> levels = levelService.findAllByTopic(topicOptional.get());
        return new ResponseEntity<>(levels, HttpStatus.OK);
    }
}

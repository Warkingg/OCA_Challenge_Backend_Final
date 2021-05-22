package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Topic;
import com.example.quizappdrycode.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private ITopicService topicService;

    @GetMapping
    public ResponseEntity<Iterable<Topic>> getAllTopic() {
        return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable ("id") Long id) {
        Optional<Topic> topicOptional = topicService.findById(id);
        return new ResponseEntity<>(topicOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        return new ResponseEntity<>(topicService.save(topic), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
        topic.setId(id);
        topicService.save(topic);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topic> deleteTopic(@PathVariable("id") Long id) {
        topicService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

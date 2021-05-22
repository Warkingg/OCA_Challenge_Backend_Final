package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Quiz;
import com.example.quizappdrycode.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private IQuizService quizService;

    @GetMapping
    public ResponseEntity<Iterable<Quiz>> getAllQuiz(){
        return new ResponseEntity<>(quizService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable ("id") Long id) {
        Optional<Quiz> quizOptional = quizService.findById(id);
        return new ResponseEntity<>(quizOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.save(quiz),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable ("id") Long id, @RequestBody Quiz quiz) {
        quiz.setId(id);
        quizService.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quiz> deleteQuiz(@PathVariable ("id") Long id) {
        quizService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.CorrectAnswer;
import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.service.ICorrectAnswerService;
import com.example.quizappdrycode.service.IQuestionService;
import com.example.quizappdrycode.service.Impl.CorrectAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
public class CorrectAnswerController {
    @Autowired
    private ICorrectAnswerService correctAnswerService;

    @Autowired
    private IQuestionService questionService;

    @GetMapping("/correctAnswers/{questionId}")
    public ResponseEntity<Iterable<CorrectAnswer>> showAllByQuestion(@PathVariable Long questionId) {
        Optional<Question> questionOptional = questionService.findById(questionId);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<CorrectAnswer> correctAnswers = correctAnswerService.findAllByQuestion(questionOptional.get());
        return new ResponseEntity<>(correctAnswers, HttpStatus.OK);
    }

    @GetMapping("/getCorrectAnswer/{id}")
    public ResponseEntity<CorrectAnswer> getCorrectAnswerDetail(@PathVariable Long id) {
        Optional<CorrectAnswer> correctAnswer = correctAnswerService.findById(id);
        return correctAnswer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/correctAnswers")
    public ResponseEntity<CorrectAnswer> createCorrectAnswer(@RequestBody CorrectAnswer correctAnswer) {
        return new ResponseEntity<>(correctAnswerService.save(correctAnswer), HttpStatus.OK);
    }

    @PutMapping("/correctAnswers/{id}")
    public ResponseEntity<CorrectAnswer> updateCorrectAnswer(@RequestBody CorrectAnswer correctAnswer, @PathVariable Long id) {
        Optional<CorrectAnswer> correctAnswerOptional = correctAnswerService.findById(id);
        if (!correctAnswerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(correctAnswerService.save(correctAnswer), HttpStatus.OK);
    }

    @DeleteMapping("/correctAnswers/{id}")
    public ResponseEntity<CorrectAnswer> deleteCorrectAnswer(@PathVariable Long id) {
        Optional<CorrectAnswer> correctAnswerOptional = correctAnswerService.findById(id);
        if (!correctAnswerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        correctAnswerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
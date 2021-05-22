package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Level;
import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.service.Impl.LevelService;
import com.example.quizappdrycode.service.Impl.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private LevelService levelService;

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }

    @GetMapping("/allQuestionByLevel/{id}")
    private ResponseEntity<Iterable<Question>> getAllQuestionByLevel(@PathVariable Long id){
        Optional<Level> level = levelService.findById(id);
        if (level.isPresent()){
            Iterable<Question> questions = questionService.findAllByLevel(level.get());
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            questionService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable Long id) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }
}

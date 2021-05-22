package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.QuestionType;
import com.example.quizappdrycode.service.Impl.TypeOfQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class QuestionTypeController {
    @Autowired
    private TypeOfQuestionService typeOfQuestionService;

    @GetMapping("/typeOfQuestions")
    public ResponseEntity<Iterable<QuestionType>> showAll() {
        Iterable<QuestionType> typeOfQuestions = typeOfQuestionService.findAll();
        return new ResponseEntity<>(typeOfQuestions, HttpStatus.OK);
    }

    @GetMapping("/typeOfQuestions/{id}")
    public ResponseEntity<QuestionType> getTypeOfQuestion(@PathVariable Long id) {
        Optional<QuestionType> questionTypeOptional = typeOfQuestionService.findById(id);
        if (questionTypeOptional.isPresent()){
            return new ResponseEntity<>(questionTypeOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.QuestionType;
import com.example.quizappdrycode.service.Impl.QuestionTypeService;
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
    private QuestionTypeService questionTypeService;

    @GetMapping("/QuestionTypes")
    public ResponseEntity<Iterable<QuestionType>> showAll() {
        Iterable<QuestionType> questionTypes = questionTypeService.findAll();
        return new ResponseEntity<>(questionTypes, HttpStatus.OK);
    }

    @GetMapping("/QuestionTypes/{id}")
    public ResponseEntity<QuestionType> getQuestionType(@PathVariable Long id) {
        Optional<QuestionType> questionTypeOptional = questionTypeService.findById(id);
        if (questionTypeOptional.isPresent()){
            return new ResponseEntity<>(questionTypeOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

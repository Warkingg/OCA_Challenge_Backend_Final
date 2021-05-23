package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Answer;
import com.example.quizappdrycode.model.Question;
import com.example.quizappdrycode.service.IAnswerService;
import com.example.quizappdrycode.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private IAnswerService iAnswerService;

    @Autowired
    private IQuestionService iQuestionService;

    @PostMapping("/create/{questionId}")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer, @PathVariable("questionId") Long id) {
        Optional<Question> questionOptional = iQuestionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iAnswerService.save(answer), HttpStatus.OK);
    }

    @GetMapping("/getAllAnswerByQuestion/{questionId}")
    public ResponseEntity<Iterable<Answer>> showAllAnswerByQuestion(@PathVariable("questionId") Long id) {
        Optional<Question> questionOptional = iQuestionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Answer> answers = iAnswerService.findALlAnswerByQuestion(questionOptional.get());
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answer = iAnswerService.findById(id);
        if (answer.isPresent()){
            return new ResponseEntity<>(answer.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer, @PathVariable Long id) {
        Optional<Answer> answerOptional = iAnswerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answer.setId(answerOptional.get().getId());
        return new ResponseEntity<>(iAnswerService.save(answer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id) {
        Optional<Answer> answerOptional = iAnswerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iAnswerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.Result;
import com.example.quizappdrycode.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
public class ResultController {
    @Autowired
    private IResultService resultService;


    //@Autowired
    //private IUserService userService;


    // @GetMapping("/findAllResultByUser")
    //public ResponseEntity<Iterable<Result>> findAllResultByUser(@RequestParam("user") String user) {
    //   User currentUser = userService.findByUsername(user);
    //   if (currentUser == null) {
    //       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //   }
//  Iterable<Result> result = resultService.findAllByUser(currentUser);
    //  return new ResponseEntity<>(result, HttpStatus.OK);
    //}

    @PostMapping("/results")
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        return new ResponseEntity<>(resultService.save(result), HttpStatus.CREATED);
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<Result> getResult(@PathVariable Long id) {
        Optional<Result> result = resultService.findById(id);
        return result.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //@GetMapping("/findResultByHistoryAndUser")
    //public ResponseEntity<Result> findResultByHistoryAndUser(@RequestParam("history") String history, @RequestParam("user") String user) {
        //History currentHistory = historyService.findByName(history);
        //if (history == null) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        //User currentUser = userService.findByUsername(user);
        //if (currentHistory == null) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        //Result result = resultService.findByHistoryAndUser(currentHistory, currentUser);
        //return new ResponseEntity<>(result, HttpStatus.OK);
    //}
}
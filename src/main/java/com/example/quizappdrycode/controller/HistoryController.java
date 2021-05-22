package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.History;
import com.example.quizappdrycode.model.User;
import com.example.quizappdrycode.service.IHistoryService;
import com.example.quizappdrycode.service.IUserService;
import com.example.quizappdrycode.service.Impl.HistoryService;
import com.example.quizappdrycode.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@CrossOrigin("*")
public class HistoryController {
    @Autowired
    private Environment env;

    @Autowired
    private IHistoryService historyService;

    @Autowired
    private IUserService userService;

    @GetMapping("/histories")
    public ResponseEntity<Iterable<History>> listHistory(){
        Iterable<History> histories = historyService.findAll();
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }
    @GetMapping("/histories/{id}")
    public ResponseEntity<History> historyDetail(@PathVariable Long id){
        Optional<History> historyOptional = historyService.findById(id);
        return historyOptional.map(history -> new ResponseEntity<>(history, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/histories")
    public ResponseEntity<History> createHistory(@RequestBody History history){
        return new ResponseEntity<>(historyService.save(history),HttpStatus.CREATED);
    }

    @PutMapping("/histories/{id}")
    public ResponseEntity<History> updateHistory(@RequestBody History history, @PathVariable Long id) {
        Optional<History> historyOptional = historyService.findById(id);
        if (!historyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        history.setId(historyOptional.get().getId());
        history.setParticipants(historyOptional.get().getParticipants());
        return new ResponseEntity<>(historyService.save(history), HttpStatus.OK);
    }

    @DeleteMapping("/histories/{id}")
    public ResponseEntity<History> deleteHistory(@PathVariable Long id) {
        historyService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/doHistory/{id}")
    public ResponseEntity<History> doHistory(@PathVariable Long id){
        Optional<History> historyOptional = historyService.findById(id);
        if (!historyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LocalDateTime currentTime = LocalDateTime.now();
        if (historyOptional.get().getStartedDate().isAfter(currentTime)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(historyOptional.get(),HttpStatus.OK);
    }

    @PostMapping("/join/{examId}")
    public ResponseEntity<History> joinHistory(@RequestBody User user, @PathVariable Long historyId){
        Optional<History> historyOptional = historyService.findById(historyId);
        if (!historyOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Optional<User> userOptional = userService.findById(user.getId());
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        historyOptional.get().getParticipants().add(userOptional.get());
        //emailService.sendEmail(userOptional.get().getEmail(), env.getProperty("examSubject"), env.getProperty("linkExam") + examOptional.get().getId());
        historyService.save(historyOptional.get());
        return new ResponseEntity<>(historyOptional.get(),HttpStatus.OK);
    }
}
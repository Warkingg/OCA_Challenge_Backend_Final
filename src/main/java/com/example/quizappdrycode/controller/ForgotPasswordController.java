package com.example.quizappdrycode.controller;

import com.example.quizappdrycode.model.PasswordForgotForm;
import com.example.quizappdrycode.model.User;
import com.example.quizappdrycode.model.VerificationToken;
import com.example.quizappdrycode.service.Impl.EmailService;
import com.example.quizappdrycode.service.Impl.UserService;
import com.example.quizappdrycode.service.Impl.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.quizappdrycode.model.StaticVariable.SUBJECT_PASSWORD_FORGOT;
import static com.example.quizappdrycode.model.StaticVariable.TEXT_PASSWORD_FORGOT;

@RestController
@CrossOrigin("*")
public class ForgotPasswordController {

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private VerificationTokenService verificationTokenService;


    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody PasswordForgotForm passwordForgotForm){
        User user = userService.findByEmail(passwordForgotForm.getEmail());
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        VerificationToken token = new VerificationToken(user);
        token.setExpiryDate(10);
        verificationTokenService.save(token);
        emailService.sendEmail(passwordForgotForm.getEmail(), SUBJECT_PASSWORD_FORGOT,  TEXT_PASSWORD_FORGOT  + env.getProperty("forgotPasswordLink") + "?token=" + token.getToken());
        return new ResponseEntity<>(passwordForgotForm, HttpStatus.OK);
    }

}

package org.example.controller;

import org.example.entity.User;
import org.example.payload.request.LoginRequest;
import org.example.payload.request.UserRequest;
import org.example.servise.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static AuthenticationController authenticationController;
    @Autowired
    private AuthenticationService authenticationService;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{8,20}$");
    private static final Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");

    private AuthenticationController() {
        authenticationService = AuthenticationService.getInstance();
    }

    public static synchronized AuthenticationController getInstance() {
        if (authenticationController == null) {
            authenticationController = new AuthenticationController();
        }
        return authenticationController;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> logIn(@RequestBody LoginRequest login) {
        if (authenticationService.checkIfUserExists(login.getEmail(), login.getPassword())) {
            return ResponseEntity.ok("token: "+ authenticationService.logIn(login.getEmail(),login.getPassword()));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong email/password");
    }

    public boolean authUser(String id, String token) {
        if (token.length() != 18) {
            throw new IllegalArgumentException("the token is not valid");
        }
        return authenticationService.authUser(token);
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserRequest user) {
        Matcher matchMail = emailPattern.matcher(user.getEmail());
        Matcher matchPassword = PASSWORD_PATTERN.matcher(user.getPassword());
        boolean emailMatchFound = matchMail.matches();
        boolean passwordMatchFound = matchPassword.matches();
        if (!emailMatchFound) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("wrong email");
        }
        if (!passwordMatchFound) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("wrong password");
        }
        authenticationService.createUser(user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully!");
    }
}


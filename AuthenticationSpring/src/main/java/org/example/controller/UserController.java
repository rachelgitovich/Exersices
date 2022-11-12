package org.example.controller;

import org.example.payload.request.EmailRequest;
import org.example.payload.request.NameRequest;
import org.example.payload.request.PasswordRequest;
import org.example.servise.AuthenticationService;
import org.example.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserController {
    private static UserController userController;
    @Autowired
    private UserService userService;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{8,20}$");
    private static final Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");
    private static AuthenticationService authenticationService;


    private UserController() {
        userService = UserService.getInstance();
        authenticationService = AuthenticationService.getInstance();
    }

    public static synchronized UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    @RequestMapping(value = "/updateName", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateUserName(@RequestHeader String token, @RequestBody NameRequest userName) {
        if (authenticateUser(token)) {
            userService.updateUserName(authenticationService.getId(token), userName.getName());
            return ResponseEntity.status(HttpStatus.OK).body("name updated successfully");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user is not logged in");
    }

    @RequestMapping(value = "/updateEmail", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateEmail(@RequestHeader String token, @RequestBody EmailRequest email) {
        if (authenticateUser(token)) {
            if (validateEmail(email.getEmail())) {
                userService.updateEmail(authenticationService.getId(token), email.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body("email updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("wrong email");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user is not logged in");
        }

    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.PATCH)
    public ResponseEntity<String> updatePassword(@RequestHeader String token, @RequestBody PasswordRequest password) {
        if (authenticateUser(token)) {
            if (validatePassword(password.getPassword())) {
                userService.updatePassword(authenticationService.getId(token), password.getPassword());
                return ResponseEntity.status(HttpStatus.OK).body("password updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("password is not valid");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user is not logged in");
        }

    }

    public boolean authenticateUser(String token) {
        return authenticationService.authUser(token);
    }

    public boolean validateEmail(String email) {
        Matcher m = emailPattern.matcher(email);
        return m.matches();
    }

    public boolean validatePassword(String password) {
        Matcher m = PASSWORD_PATTERN.matcher(password);
        return m.matches();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> deleteUser(@RequestHeader String token) {
        if (authenticateUser(token)) {
            authenticationService.deleteUserFromMap(authenticationService.getId(token));
            userService.deleteUser(authenticationService.getId(token));
            return ResponseEntity.status(HttpStatus.OK).body("user deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user is not logged in");
        }
    }
}

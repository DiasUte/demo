package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public ResponseEntity<String> getUsers() {
        try{
            return ResponseEntity.ok("Successfull123");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserEntity user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("User successfully registered");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User registration failed");
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity getUserById(@RequestParam Long id) {
        try {

            return ResponseEntity.ok(userService.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User registration failed");
        }
    }


}

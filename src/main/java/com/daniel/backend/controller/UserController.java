package com.daniel.backend.controller;

import com.daniel.backend.document.User;
import com.daniel.backend.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUSers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(
            @RequestBody User user
    ) {
        return userService.save(user);
    }
}
package com.example.splitwise.controllers;

import com.example.splitwise.models.User;
import com.example.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUser(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}

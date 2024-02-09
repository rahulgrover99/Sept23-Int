package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.RegisterUserRequestDto;
import com.example.bookmyshow.dtos.RegisterUserResponseDto;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User getUser(@PathVariable("userId") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request) {
        User user = userService.registerUser(request.getName(), request.getEmail(), request.getPassword());
        return new RegisterUserResponseDto(user.getId());

    }


}

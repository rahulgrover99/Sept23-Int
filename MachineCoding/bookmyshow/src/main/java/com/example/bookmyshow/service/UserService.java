package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.NoUserFound;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(NoUserFound::new);
    }

    public User registerUser(String name, String email, String password) {

        User newUser = User.builder().name(name).email(email).password(password).build();
        userRepository.save(newUser);

        return newUser;
    }

}

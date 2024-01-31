package com.example.bookmyshow.controllers;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final MovieRepository movieRepository;

    public TicketController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @GetMapping(path = "/book")
    public String bookTicket() {
        System.out.println("Request hits the server");
        movieRepository.save(
                Movie.builder()
                        .id(1L)
                        .name("Kal ho na ho")
                        .category("drama")
                        .build());
        System.out.println(movieRepository.findAll());
        System.out.println(movieRepository.findMovieByName("Kal ho na ho"));

        System.out.println(movieRepository.findMovieByNameAndCategory("Kal ho na ho", "drama"));
        return "Hello, world!";
    }

    @GetMapping(path = "/get")
    public String getTicket() {
        System.out.println("Request hits the server - 2");
        return "Get the ticket for you, world!";
    }
}

package com.example.bookmyshow.repository;

import com.example.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface MovieRepository extends
        JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByName(String name);
    Optional<Movie> findMovieByNameAndCategory(String name, String category);

}

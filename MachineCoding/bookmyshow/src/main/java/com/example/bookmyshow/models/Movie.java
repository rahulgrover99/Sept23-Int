package com.example.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "movies")
public class Movie {
    @Id
    private Long id;
    private String name;
    private String language;
    @Column(nullable = true)
    private double rating;
    private int duration;
    private String category;
}

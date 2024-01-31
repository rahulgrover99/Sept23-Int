package com.example.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private Long id;
    private String name;
    private String language;
    @Column(nullable = true)
    private double rating;
    private int duration;
    private String category;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                '}';
    }
}

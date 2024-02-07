package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Region extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "region")
    private List<Theatre> theatreList;
    private double longitude;
    private double latitude;
}

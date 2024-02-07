package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @ManyToOne
    private Region region;
}

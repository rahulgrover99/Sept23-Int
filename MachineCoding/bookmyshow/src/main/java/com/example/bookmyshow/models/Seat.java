package com.example.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

@Entity
public class Seat extends BaseModel {
    @Column(name = "seat_number")
    private int number;
    private char rowNum;
    private int colNum;
    @Enumerated
    private SeatType seatType;
}

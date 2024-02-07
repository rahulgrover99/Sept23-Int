package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Booking extends BaseModel {
    @OneToMany
    private List<ShowSeat> showSeatList;
    private Date bookedAt;

    @ManyToOne
    private Show show;
    private double amount;

}

package com.example.bookmyshow.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookTicketResponseDto {
    private Long bookingId;
    private double amount;
    private List<Long> seatNumbers;
    private String theatreName;
}

package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookTicketRequestDto;
import com.example.bookmyshow.dtos.BookTicketResponseDto;
import com.example.bookmyshow.models.BaseModel;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repository.MovieRepository;
import com.example.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final BookingService bookingService;

    @Autowired
    public TicketController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping(path = "/book")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody BookTicketResponseDto bookTicket(
            @RequestBody BookTicketRequestDto requestDto) {

        System.out.println(requestDto);

        Booking booking = bookingService.bookMovie(requestDto.getShowSeatIds());
        return BookTicketResponseDto.builder()
                .bookingId(booking.getId())
                .amount(booking.getAmount())
                .seatNumbers(booking.getShowSeatList().stream().map(BaseModel::getId).collect(Collectors.toList()))
                .theatreName(booking.getShow().getScreen().getTheatre().getName())
                .build();
    }

    @GetMapping(path = "/get")
    @ResponseStatus(HttpStatus.OK)
    public String getTicket() {
        System.out.println("Request hits the server - 2");
        return "Get the ticket for you, world!";
    }
}

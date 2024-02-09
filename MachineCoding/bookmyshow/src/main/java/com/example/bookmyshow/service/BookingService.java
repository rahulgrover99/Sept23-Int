package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.BadRequestException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatStatus;
import com.example.bookmyshow.repository.BookingRepository;
import com.example.bookmyshow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    /*
    * 1. Begin a transaction at isolation level -> serializable
    * 2. We try to fetch ShowSeat objects based on the show seat Id.
    * 3. Validate that ids were valid, and we got same number of seats returned
    * == the ids mentioned in the request.
    * 4. Update the status of a show seat from available to blocked.
    * 5. Save that show seat.
    * 6. Close the transaction.
    *
    * */

    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIds) {

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // The number of showseats selected by the user and sent to us.
        // The number of corresponding seats we got from DB.
        if (showSeats.size() != showSeatIds.size()) {
            throw new BadRequestException();
        }

        for (ShowSeat showSeat: showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new BadRequestException("Seat not available.");
            }

            // Only updates the status of java object not the database row.
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);

        }

        // Save the updated status to the DB.
        showSeatRepository.saveAll(showSeats);

        Show show = showSeats.get(0).getShow();
        Booking booking = Booking.builder()
                .bookedAt(new Date())
                .amount(12.0)
                .showSeatList(showSeats)
                .show(show)
                .build();

        bookingRepository.save(booking);

        return booking;
    }


}

package com.example.bookmyshow.repository;

import com.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {


    List<ShowSeat> findAllById(Iterable<Long> ids);
}

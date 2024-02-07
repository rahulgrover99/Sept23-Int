package com.example.bookmyshow.dtos;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDto {
    List<Long> showSeatIds;

    @Override
    public String toString() {
        return "BookTicketRequestDto{" +
                "showSeatIds=" + showSeatIds +
                '}';
    }
}

package com.codemaniac.hotelsystem.dtos;

import com.codemaniac.hotelsystem.entities.Guest;
import com.codemaniac.hotelsystem.entities.Reservation;
import lombok.Data;

@Data
public class ReservationDto {
    private Guest guest;
    private Reservation reservation;
}

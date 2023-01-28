package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Reservation {

    private Long reservationId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private long numOfNights;
    private double rate;
    private double totalCost;
}

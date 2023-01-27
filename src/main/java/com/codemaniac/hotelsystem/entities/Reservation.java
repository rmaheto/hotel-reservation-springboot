package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_number")
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private long numOfNights;
    private double rate;
    private double totalCost;
}

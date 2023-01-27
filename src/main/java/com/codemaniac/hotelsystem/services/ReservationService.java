package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Reservation;

import java.util.List;

public interface ReservationService {
    public Reservation getReservation(long reservationId);
    public List<Reservation> getAllReservations();
    public Reservation createReservation(Reservation reservation);
    public Reservation updateReservation(long reservationId, Reservation reservation);
    public void deleteReservation(long reservationId);
}

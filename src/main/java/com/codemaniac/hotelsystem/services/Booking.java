package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.dtos.ReservationDto;

import java.util.Collection;

public interface Booking {

    public void book(ReservationDto reservationDto);
    public ReservationDto getBooking(long reservationId);
    public Collection<Booking> getBookings();
    public void updateBooking(long reservationId, ReservationDto reservationDto);
    public void deleteBooking(long reservationId);
}

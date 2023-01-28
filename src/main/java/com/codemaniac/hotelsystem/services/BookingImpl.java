package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.dtos.ReservationDto;
import com.codemaniac.hotelsystem.entities.Guest;
import com.codemaniac.hotelsystem.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class BookingImpl implements Booking{
    @Autowired
    private GuestService guestService;
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void book(ReservationDto reservationDto) {

        Guest guest = modelMapper.map(reservationDto, Guest.class);
        Reservation reservation = modelMapper.map(reservationDto,Reservation.class);

        Guest savedGuest = guestService.createGuest(guest);
        reservation.setGuest(savedGuest);
        reservationService.createReservation(reservation);
    }

    @Override
    public ReservationDto getBooking(long reservationId) {
        return null;
    }

    @Override
    public Collection<Booking> getBookings() {
        return null;
    }

    @Override
    public void updateBooking(long reservationId, ReservationDto reservationDto) {

    }

    @Override
    public void deleteBooking(long reservationId) {

    }
}

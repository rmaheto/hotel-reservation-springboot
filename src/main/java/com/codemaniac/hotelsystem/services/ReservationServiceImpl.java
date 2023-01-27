package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Guest;
import com.codemaniac.hotelsystem.entities.Rate;
import com.codemaniac.hotelsystem.entities.Reservation;
import com.codemaniac.hotelsystem.entities.Room;
import com.codemaniac.hotelsystem.repository.ReservationRepository;
import com.codemaniac.hotelsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RateService rateService;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Reservation getReservation(long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Room room = roomService.getRoom(reservation.getRoom().getRoomNumber());
        Guest guest = guestService.getGuest(reservation.getGuest().getGuestId());
        if (room != null && guest != null) {
            room.setAvailable(false);
            roomService.updateRoom(room.getRoomNumber(), room);
            reservation.setRoom(room);
            reservation.setGuest(guest);
            reservation.setTotalCost(reservation.getRoom().getRoomType().getRate().getRatePerNight()
                    * calculateNumOfNights(reservation.getCheckInDate(), reservation.getCheckOutDate()));
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public Reservation updateReservation(long reservationId, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservationId).orElse(null);
        if (existingReservation != null) {
            Room room = roomService.getRoom(reservation.getRoom().getRoomNumber());
            Guest guest = guestService.getGuest(reservation.getGuest().getGuestId());
            if (room != null && guest != null) {
                existingReservation.setCheckInDate(reservation.getCheckInDate());
                existingReservation.setCheckOutDate(reservation.getCheckOutDate());
                existingReservation.setNumOfNights(calculateNumOfNights(reservation.getCheckInDate(), reservation.getCheckOutDate()));
                existingReservation.setRoom(room);
                existingReservation.setGuest(guest);
                existingReservation.setRate(room.getRoomType().getRate().getRatePerNight());
                existingReservation.setTotalCost(reservation.getRoom().getRoomType().getRate().getRatePerNight()
                        * calculateNumOfNights(reservation.getCheckInDate(), reservation.getCheckOutDate()));
                return reservationRepository.save(existingReservation);
            }
        }
        return null;
    }

    @Override
    public void deleteReservation(long reservationId) {
        Reservation existingReservation = reservationRepository.findById(reservationId).orElse(null);
        if (existingReservation != null) {
            Room room = existingReservation.getRoom();
            room.setAvailable(true);
            roomService.updateRoom(room.getRoomNumber(), room);
            paymentService.deletePayment(existingReservation.getReservationId());
            reservationRepository.deleteById(reservationId);
        }
    }

    private long calculateNumOfNights(LocalDate checkInDate, LocalDate checkOutDate) {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        List<Room> allRooms = roomRepository.findAll();
        List<Reservation> allReservations = reservationRepository.findAll();
        List<Room> availableRooms = new ArrayList<>();

        for(Room room : allRooms) {
            boolean isRoomAvailable = true;
            for(Reservation reservation : allReservations) {
                if(reservation.getRoom().getRoomNumber().equals(room.getRoomNumber())) {
                    if((checkIn.isAfter(reservation.getCheckInDate()) && checkIn.isBefore(reservation.getCheckOutDate()))
                            || (checkOut.isAfter(reservation.getCheckInDate()) && checkOut.isBefore(reservation.getCheckOutDate()))
                            || (checkIn.isBefore(reservation.getCheckInDate()) && checkOut.isAfter(reservation.getCheckOutDate()))) {
                        isRoomAvailable = false;
                        break;
                    }
                }
            }
            if(isRoomAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    
}

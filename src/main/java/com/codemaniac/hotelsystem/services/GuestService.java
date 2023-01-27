package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Guest;

import java.util.List;

public interface GuestService {
    public Guest getGuest(long guestId);
    public List<Guest> getAllGuests();
    public Guest createGuest(Guest guest);
    public Guest updateGuest(long guestId, Guest guest);
    public void deleteGuest(long guestId);
}

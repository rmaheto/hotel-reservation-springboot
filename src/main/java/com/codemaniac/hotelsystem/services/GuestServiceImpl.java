package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Guest;
import com.codemaniac.hotelsystem.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuestServiceImpl implements GuestService{
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest getGuest(long guestId) {
        return guestRepository.findById(guestId).orElse(null);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(long guestId, Guest guest) {
        Guest existingGuest = guestRepository.findById(guestId).orElse(null);
        if(existingGuest != null) {
            existingGuest.setFirstName(guest.getFirstName());
            existingGuest.setLastName(guest.getLastName());
            existingGuest.setEmail(guest.getEmail());
            existingGuest.setPhone(guest.getPhone());
            return guestRepository.save(existingGuest);
        }
        return null;
    }

    @Override
    public void deleteGuest(long guestId) {
        guestRepository.deleteById(guestId);
    }
}

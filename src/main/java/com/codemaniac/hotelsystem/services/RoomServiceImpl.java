package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Room;
import com.codemaniac.hotelsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room getRoom(String roomNumber) {
        return roomRepository.findById(roomNumber).orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(String roomNumber, Room room) {
        Room existingRoom = roomRepository.findById(roomNumber).orElse(null);
        if(existingRoom != null) {
            existingRoom.setRoomType(room.getRoomType());
            existingRoom.setBedType(room.getBedType());
            existingRoom.setMaxOccupancy(room.getMaxOccupancy());
            existingRoom.setAvailable(room.isAvailable());
            return roomRepository.save(existingRoom);
        }
        return null;
    }

    @Override
    public void deleteRoom(String roomNumber) {
        roomRepository.deleteById(roomNumber);
    }
}

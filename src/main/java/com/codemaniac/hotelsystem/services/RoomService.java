package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Room;

import java.util.List;

public interface RoomService {
    public Room getRoom(String roomNumber);
    public List<Room> getAllRooms();
    public Room createRoom(Room room);
    public Room updateRoom(String roomNumber, Room room);
    public void deleteRoom(String roomNumber);
}

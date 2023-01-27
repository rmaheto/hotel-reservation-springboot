package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.RoomType;

import java.util.List;

public interface RoomTypeService {
    public RoomType getRoomType(String roomType);
    public List<RoomType> getAllRoomTypes();
    public RoomType createRoomType(RoomType roomType);
    public RoomType updateRoomType(String roomType, RoomType newRoomType);
    public void deleteRoomType(String roomType);
}

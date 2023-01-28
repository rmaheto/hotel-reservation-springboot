package com.codemaniac.hotelsystem.entities;

import lombok.Data;

@Data
public class Room {

    private String roomNumber;
    private RoomType roomType;
    private String bedType;
    private int maxOccupancy;
    private boolean available;
}

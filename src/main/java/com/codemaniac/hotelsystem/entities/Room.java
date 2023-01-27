package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "room_type_room_type")
    private RoomType roomType;
    private String bedType;
    private int maxOccupancy;
    private boolean available;
}

package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room_types")
@Data
public class RoomType {
    @Id
    private String roomType;
    @OneToOne
    @JoinColumn(name = "rate_rate_id")
    private Rate rate;
    private String description;
}

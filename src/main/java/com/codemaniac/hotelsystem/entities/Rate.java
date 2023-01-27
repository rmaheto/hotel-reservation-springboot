package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "rates")
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateId;

    @ManyToOne
    @JoinColumn(name = "room_type_room_type")
    private RoomType roomType;
    private double ratePerNight;
    private double extraPersonCharge;
}

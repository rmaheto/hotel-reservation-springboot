package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;



@Data
public class Rate {

    private Long rateId;
    private RoomType roomType;
    private double ratePerNight;
    private double extraPersonCharge;
}

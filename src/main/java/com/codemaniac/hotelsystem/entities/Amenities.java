package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;


@Data
public class Amenities {
    private Long amenitiesId;
    private String description;
}

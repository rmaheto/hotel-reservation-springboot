package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "amenities")
@Data
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenitiesId;

    private String description;
}

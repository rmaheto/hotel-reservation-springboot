package com.codemaniac.hotelsystem.entities;

import lombok.Data;

@Data
public class RoomType {

    private String roomType;
    private Rate rate;
    private String description;
}

package com.codemaniac.hotelsystem.entities;

import lombok.Data;

@Data
public class Staff {

    private Long staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
}

package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
}

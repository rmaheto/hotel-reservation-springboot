package com.codemaniac.hotelsystem.entities;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "guests")
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

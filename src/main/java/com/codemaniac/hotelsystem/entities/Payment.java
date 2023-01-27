package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private String cardNumber;
    private String cardHolderName;
    private Date expirationDate;
    private String cvv;
}

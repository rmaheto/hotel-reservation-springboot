package com.codemaniac.hotelsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class Payment {

    private Long paymentId;
    private Reservation reservation;
    private String cardNumber;
    private String cardHolderName;
    private Date expirationDate;
    private String cvv;
}

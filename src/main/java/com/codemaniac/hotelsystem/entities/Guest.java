package com.codemaniac.hotelsystem.entities;



import lombok.Data;

import javax.persistence.*;

@Data
public class Guest {

    private Long guestId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

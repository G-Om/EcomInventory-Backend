package com.ecominventory.root.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private Date date;

    private int total;

    @Column(name = "payment_status")
    private boolean pay_status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

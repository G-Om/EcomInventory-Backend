package com.ecominventory.root.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private int total;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> items = new HashSet<>();
}

package com.ecominventory.root.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cart_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItem {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private int quantity;

    @Column(name = "sub_total")
    private int subtotal;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

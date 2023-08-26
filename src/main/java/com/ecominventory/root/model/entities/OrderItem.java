package com.ecominventory.root.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;

@Entity(name = "order_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private int quantity;

    @Column(name = "sub_total")
    private int subtotal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItem(int quantity, int subtotal, Product product) {
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.product = product;
    }
}

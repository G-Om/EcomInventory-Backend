package com.ecominventory.root.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String name;

    private int price;

    private int quantity;

    private String description;

    private String image;

    @ManyToMany(mappedBy = "products")
    private Set<Categories> categories = new HashSet<>();
}


















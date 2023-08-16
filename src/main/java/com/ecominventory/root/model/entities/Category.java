package com.ecominventory.root.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    public Category(String name) {
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Product> products;
}

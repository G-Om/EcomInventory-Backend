package com.ecominventory.root.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "username")
    private String name;

    private String password;

    private String email;

    private String role;

    private boolean membership;

    @Column(name = "create_time")
    private Date time_created;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> favourites = new HashSet<>();

    public User(String username, String email, String role, Date dateTime) {
        this.email = email;
        this.name = username;
        this.role = role;
        this.time_created = dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        cart.setUser(this);
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public void setFavourites(Set<Product> favourites) {
        this.favourites = favourites;
    }
}

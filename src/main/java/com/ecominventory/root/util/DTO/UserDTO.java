package com.ecominventory.root.util.DTO;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.Orders;
import com.ecominventory.root.model.entities.Product;
import jakarta.servlet.http.PushBuilder;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.Set;

public class UserDTO
{
    public Long id;

    public String username;

    public String email;

    public String role;

    public int cartId;

    public  Set<Product> favourites;


    public UserDTO(Long id, String username, String email, String role, int cartId, Set<Product> favourites) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.cartId = cartId;
        this.favourites = favourites;
    }
}

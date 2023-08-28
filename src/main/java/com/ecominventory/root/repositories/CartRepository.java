package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Integer userId);
}

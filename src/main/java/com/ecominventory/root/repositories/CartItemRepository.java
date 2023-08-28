package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //    Should Always get Cart and then mapped item by item_id so no need of find by name
    CartItem findByProduct(Product product);
}

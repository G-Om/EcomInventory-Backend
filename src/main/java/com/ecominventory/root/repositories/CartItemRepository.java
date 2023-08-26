package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //    Should Always get Cart and then mapped item by item_id so no need of find by name
}

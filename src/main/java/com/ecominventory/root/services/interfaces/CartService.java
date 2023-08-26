package com.ecominventory.root.services.interfaces;

import com.ecominventory.root.model.entities.Cart;

public interface CartService extends BaseService<Cart> {

    Cart findByUserId(Integer userId);
}

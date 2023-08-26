package com.ecominventory.root.services.interfaces;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.Orders;

public interface CartOrderService extends BaseService<Cart> {

    Cart findByUserId(Integer userId);

    Boolean placeOrder(Orders order);
}

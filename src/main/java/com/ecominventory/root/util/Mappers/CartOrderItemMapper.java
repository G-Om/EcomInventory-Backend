package com.ecominventory.root.util.Mappers;

import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.model.entities.OrderItem;

import java.util.function.Function;

public class CartOrderItemMapper implements Function<CartItem, OrderItem> {
    @Override
    public OrderItem apply(CartItem cartItem) {
        return new OrderItem(
                cartItem.getQuantity(),
                cartItem.getSubtotal(),
                cartItem.getProduct()
        );
    }
}

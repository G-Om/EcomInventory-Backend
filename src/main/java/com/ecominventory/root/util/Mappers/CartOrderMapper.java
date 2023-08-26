package com.ecominventory.root.util.Mappers;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.OrderItem;
import com.ecominventory.root.model.entities.Orders;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CartOrderMapper implements Function<Cart, Orders> {
//    Attributes of orders entity:
//    id, date, total, paystatus, user
//    Attributes of cart:
//    id, total, user, set(items)


    CartOrderItemMapper itemMapper = new CartOrderItemMapper();
    @Override
    public Orders apply(Cart cart) {

        Orders order = new Orders(
                cart.getTotal(),
                cart.getUser()
        );
        order.setItems(
                cart.getItems().stream().map(
                        cartItem -> {
                            OrderItem item = itemMapper.apply(cartItem);
                            item.setOrder(order);
                            return item;
                        }
                ).collect(Collectors.toSet())
        );
        return order;
    }
}

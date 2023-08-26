package com.ecominventory.root.controller.ordersmanagement;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.Orders;
import com.ecominventory.root.services.interfaces.CartOrderService;
import com.ecominventory.root.util.Mappers.CartOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    CartOrderService cartOrderService;

    CartOrderMapper cartOrderMapper = new CartOrderMapper();

    @GetMapping("")
    public String getMessage(){
        return "Hello Place an order!";
    }

    @PostMapping("")
    public ResponseEntity<Boolean> placeOrder(@RequestParam int userid) {
        Cart cart = cartOrderService.findByUserId(userid);
        if (cart.equals(null)) return ResponseEntity.ofNullable(true);
        Orders order = cartOrderMapper.apply(cart);

        return ResponseEntity.ok(cartOrderService.placeOrder(order));
    }
}

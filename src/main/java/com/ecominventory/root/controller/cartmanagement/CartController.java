package com.ecominventory.root.controller.cartmanagement;

import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.services.implementation.CartOrderService;
import com.ecominventory.root.util.DTO.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartOrderService cartService;

    @GetMapping("/")
    public String getMessage() {
        return "I am Cart";
    }

    @PostMapping("/")
    public ResponseEntity<String> addProductToCart(@RequestBody CartRequest cartRequest) {
        if (cartRequest == null || cartRequest.getProductId() == null ||
                cartRequest.getUserId() == null)
            return (ResponseEntity<String>) ResponseEntity.noContent();

        CartItem cartItem = cartService.addProductToCart(cartRequest);
        if (cartItem == null) return (ResponseEntity<String>) ResponseEntity.internalServerError();
        return ResponseEntity.ok(cartItem.toString());
    }
}

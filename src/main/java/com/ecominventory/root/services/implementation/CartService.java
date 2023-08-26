package com.ecominventory.root.services.implementation;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.repositories.CartItemRepository;
import com.ecominventory.root.repositories.CartRepository;
import com.ecominventory.root.util.DTO.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends CURDServices<Cart> implements com.ecominventory.root.services.interfaces.CartService  {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;
    @Autowired
    CartItemRepository cartItemRepository;
    @Override
    public Cart findByUserId(Integer userId) {
        if (userId < 0) return null;
        return cartRepository.findByUserId(userId);
    }

    public CartItem addProductToCart(CartRequest cartRequest) {

        Product product = productService.findById(cartRequest.getProductId());
        Cart cart = findByUserId(Math.toIntExact(cartRequest.getUserId()));
        CartItem newCartItem = new CartItem();
//        calculate sub_total
        int subTotal = cartRequest.getQuantity() * product.getPrice();

        newCartItem.setSubtotal(subTotal);
        newCartItem.setCart(cart);
        newCartItem.setProduct(product);
        newCartItem.setQuantity(cartRequest.getQuantity());

        return cartItemRepository.save(newCartItem);
    }
}

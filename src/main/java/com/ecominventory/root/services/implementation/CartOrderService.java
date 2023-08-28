package com.ecominventory.root.services.implementation;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.CartItem;
import com.ecominventory.root.model.entities.Orders;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.repositories.CartItemRepository;
import com.ecominventory.root.repositories.CartRepository;
import com.ecominventory.root.repositories.OrdersRepository;
import com.ecominventory.root.util.DTO.CartRequest;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartOrderService extends CURDServices<Cart> implements com.ecominventory.root.services.interfaces.CartOrderService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public Cart findByUserId(Integer userId) {
        if (userId < 0) return null;
        return cartRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Boolean placeOrder(Orders order, Cart cart) {
//        Perform basic checks on order
//        if(order.isPay_status() != true) return false;
        order.setPay_status(true);
        Date date = new Date();
        order.setDate(date);
        if(ordersRepository.save(order) != null){
            cart.setTotal(0);
            cartItemRepository.deleteAll(cart.getItems());
            cart.getItems().clear();
            cartRepository.save(cart);
            return true;
        }else {
            return null;
        }
    }

    @Override
    public CartItem deleteItemFromCart(Integer userid, Long productid) {
        Cart cart = findByUserId(userid);
        Product product = productService.findById(productid);
        CartItem item = findByProduct(product, cart);
        cart.getItems().remove(item);
        cartItemRepository.delete(item);
        cartRepository.save(cart);
        refresh(cart);
        return item;
    }

    private void refresh(@NonNull Cart cart) {

        int total = 0;
        for (CartItem item: cart.getItems()) {
            total += item.getSubtotal();
        }
        cart.setTotal(total);
        cartRepository.save(cart);

    }

    private CartItem findByProduct(Product product, Cart cart) {
        for ( CartItem item : cart.getItems()) {

            if (item.getProduct() == product) {
                return item;
            }
        }
        return null;
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
//      Update Cart
        cart.setTotal(cart.getTotal() + newCartItem.getSubtotal());
        cartRepository.save(cart);
        return cartItemRepository.save(newCartItem);
    }
//    TODO: Create a method for client to update items in his cart




//    public Cart updateCart(int userid) {
//        Cart cart = findByUserId(userid);
//
//    }
}

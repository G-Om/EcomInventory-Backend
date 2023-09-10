package com.ecominventory.root.services.implementation;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.User;
import com.ecominventory.root.repositories.CartRepository;
import com.ecominventory.root.repositories.UserRepository;
import com.ecominventory.root.services.interfaces.UserServices;
import com.ecominventory.root.util.DTO.UserDTO;
import com.ecominventory.root.util.Mappers.UserDTOMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends CURDServices<User> implements UserServices {

    @Autowired
    UserRepository userRepository;

    UserDTOMapper userDTOMapper = new UserDTOMapper();

    @Autowired
    CartRepository cartRepository;

    @Override
    public UserDTO getUserByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) return null;
        return userDTOMapper.apply(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return  users.stream().map(
                            user -> {
                                return userDTOMapper.apply(user);
                            }
                    ).collect(Collectors.toList());

    }

    @Transactional
    @Override
    public User create(User user) {
        Cart cart = new Cart();
        user.setCart(cart);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            Cart cart = user.getCart();
            if (cart != null ) {
                cartRepository.delete(cart);
                userRepository.delete(user);
            }else {
                System.out.println("Cannot Delete null Cart");
            }
        }
    }
}

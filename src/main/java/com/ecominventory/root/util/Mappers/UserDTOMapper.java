package com.ecominventory.root.util.Mappers;

import com.ecominventory.root.model.entities.User;
import com.ecominventory.root.util.DTO.UserDTO;

import java.util.Date;
import java.util.function.Function;

public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                Math.toIntExact(user.getCart().getId()),
                user.getFavourites()

        );
    }

    public User applyReverse(UserDTO userDTO) {
        return new User(
                userDTO.username,
                userDTO.email,
                userDTO.role,
                new Date()
        );
    }
}

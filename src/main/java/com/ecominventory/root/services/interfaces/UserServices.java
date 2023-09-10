package com.ecominventory.root.services.interfaces;

import com.ecominventory.root.model.entities.User;
import com.ecominventory.root.util.DTO.UserDTO;

import java.util.List;

public interface UserServices extends BaseService<User> {

    @Override
    User create(User user);
    UserDTO getUserByName(String name);

    List<UserDTO> getAllUsers();

    @Override
    void delete(Long id);
}

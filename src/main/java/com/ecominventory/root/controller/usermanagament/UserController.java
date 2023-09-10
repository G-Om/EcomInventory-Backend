package com.ecominventory.root.controller.usermanagament;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.User;
import com.ecominventory.root.services.implementation.CartService;
import com.ecominventory.root.services.implementation.UserService;
import com.ecominventory.root.util.DTO.UserDTO;
import com.ecominventory.root.util.Mappers.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    UserDTOMapper userDTOMapper = new UserDTOMapper();

    @GetMapping()
    public ResponseEntity<UserDTO> getUser(@RequestParam  String username) {
        return ResponseEntity.ok(userService.getUserByName(username));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        if (userDTO  == null) {
            return ResponseEntity.ok(null);
        }else {
//            Save user
            User user = userService.create(userDTOMapper.applyReverse(userDTO));
            return ( ResponseEntity.ok(
                    userDTOMapper.apply(user)
            ));

        }
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return ResponseEntity.ok(userService.findById(id) == null);

    }

}

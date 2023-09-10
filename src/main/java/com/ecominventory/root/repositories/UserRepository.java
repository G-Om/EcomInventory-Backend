package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.Cart;
import com.ecominventory.root.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByName(String name);
}

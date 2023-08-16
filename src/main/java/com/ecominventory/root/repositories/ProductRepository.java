package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<Product> findByName(String name);
    // You can define custom query methods here if needed
}

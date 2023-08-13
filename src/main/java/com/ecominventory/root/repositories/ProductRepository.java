package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // You can define custom query methods here if needed
}

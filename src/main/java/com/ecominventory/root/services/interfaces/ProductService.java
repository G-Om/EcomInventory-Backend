package com.ecominventory.root.services.interfaces;

import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.util.DTO.ProductDTO;

import java.util.Optional;

public interface ProductService extends BaseService<Product> {
    // Define Product entity specific methods
    Product addIfNotPresent(ProductDTO productDTO);

    Optional<Product> findByName(String name);
}

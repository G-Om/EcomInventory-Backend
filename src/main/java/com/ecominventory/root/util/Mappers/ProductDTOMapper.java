package com.ecominventory.root.util.Mappers;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.util.DTO.ProductDTO;
import org.springframework.stereotype.Service;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductDTOMapper implements Function<Product, ProductDTO> {

    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getDescription(),
                product.getImage(),
                product.getCategories().stream().map(Category::getName).collect(Collectors.toList())
        );
    }
}

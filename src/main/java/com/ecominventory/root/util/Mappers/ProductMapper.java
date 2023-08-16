package com.ecominventory.root.util.Mappers;

import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.services.implementation.CategoryService;
import com.ecominventory.root.util.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductMapper implements Function< ProductDTO, Product> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Product apply(ProductDTO productDTO) {
        return new Product(
                productDTO.id(),
                productDTO.name(),
                productDTO.price(),
                productDTO.quantity(),
                productDTO.description(),
                productDTO.image(),
                productDTO.categories()
                        .stream()
                        .map(
                                catName -> {
                                    return
                                            categoryService.findByName(catName);
                                })
                        .collect(Collectors.toList())
        );
    }
}

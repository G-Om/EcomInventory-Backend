package com.ecominventory.root.controller;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.repositories.CategoryRepository;
import com.ecominventory.root.services.implementation.ProductService;
import com.ecominventory.root.util.DTO.ProductDTO;
import com.ecominventory.root.util.Mappers.ProductDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Demo {

    @Autowired
    private ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    private final ProductDTOMapper productDTOMapper = new ProductDTOMapper();

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){

        return (productService.findAll().stream()
                .map(productDTOMapper)).collect(Collectors.toList());
    }

    @PostMapping("/products")
    public Product putProducts(@RequestBody ProductDTO productDTO){

//        Later Use DTOs to store value from request and process
        return productService.addIfNotPresent(productDTO);
    }

    @GetMapping("/category")
    public List<ProductDTO> getProductsOfCategories(@RequestParam String category){
         Category categoriesEntity = categoryRepository.findByName(category);
         return categoriesEntity
                 .getProducts()
                 .stream()
                 .map(productDTOMapper)
                 .collect(Collectors.toList());
    }

    @DeleteMapping("/products")
    public void delete(Long id){
        productService.delete(id);
    }
}

















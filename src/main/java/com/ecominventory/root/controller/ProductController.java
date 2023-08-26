package com.ecominventory.root.controller;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.repositories.CategoryRepository;
import com.ecominventory.root.services.implementation.ProductService;
import com.ecominventory.root.util.DTO.ProductDTO;
import com.ecominventory.root.util.Mappers.ProductDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    CategoryRepository categoryRepository;
    private final ProductDTOMapper productDTOMapper = new ProductDTOMapper();

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) String category){
        // To fetch all products
        List<ProductDTO> productsDTO ;
        if (category == null ){
            productsDTO = productService.findAll()
                    .stream()
                    .map(productDTOMapper)
                    .collect(Collectors.toList());
            if(productsDTO.isEmpty()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(productsDTO);
        }
//        To fetch products based on categories
        Category categoriesEntity = categoryRepository.findByName(category);
        if(categoriesEntity == null) return ResponseEntity.notFound().build();          // Category not found
        productsDTO = categoriesEntity
                    .getProducts()
                    .stream()
                    .map(productDTOMapper)
                    .collect(Collectors.toList()
                    );
        return ResponseEntity.ok(productsDTO);
    }

    @PostMapping
    @PutMapping
    public Product putProducts(@RequestBody ProductDTO productDTO){

//  Used DTOs to store value from request and process
        return productService.addIfNotPresent(productDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }
}


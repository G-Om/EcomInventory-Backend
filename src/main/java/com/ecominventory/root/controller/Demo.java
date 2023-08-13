package com.ecominventory.root.controller;

import com.ecominventory.root.model.entities.Categories;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.repositories.CategoryRepository;
import com.ecominventory.root.repositories.ProductRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Demo {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public String putProducts(@RequestBody Product product){

//        Later Use DTOs to store value from request and process
        Categories category = new Categories("shirt");
        product.getCategories().add(category);
        category.getProducts().add(product);
        productRepository.save(product);
        categoryRepository.save(category);
        return "OK";
    }

}

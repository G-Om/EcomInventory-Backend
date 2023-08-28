package com.ecominventory.root.services.implementation;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.model.entities.Product;
import com.ecominventory.root.repositories.ProductRepository;
import com.ecominventory.root.util.DTO.ProductDTO;
import com.ecominventory.root.util.Mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService extends CURDServices<Product> implements com.ecominventory.root.services.interfaces.ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product addIfNotPresent(ProductDTO productDTO) {
        if ( productRepository.findByName(productDTO.name()).isEmpty()){
//            Check if category is already present
            Product product = productMapper.apply(productDTO);
            List<Category> categoryList = product.getCategories();
            for (Category category : categoryList){
                category.setProducts(Arrays.asList(product));
                categoryService.addIfNotPresent(category);
            }
            return productRepository.save(product);
        }else {
            return null;
        }
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    // Implement Product specific methods which are defined in ProductService


}

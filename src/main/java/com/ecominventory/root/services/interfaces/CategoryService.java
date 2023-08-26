package com.ecominventory.root.services.interfaces;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.model.entities.Product;
import org.springframework.stereotype.Service;


public interface CategoryService extends BaseService<Category> {

    Category addIfNotPresent(Category category);

    Category findByName(String name);
}

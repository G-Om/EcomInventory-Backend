package com.ecominventory.root.services.implementation;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CURDServices<Category> implements com.ecominventory.root.services.interfaces.CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category addIfNotPresent(Category category) {
        if( repository.findByName(category.getName()) == null){
            return repository.save(category);
        }else return null;
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name);
    }


}

package com.ecominventory.root.repositories;

import com.ecominventory.root.model.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    // You can define custom query methods here if needed

}

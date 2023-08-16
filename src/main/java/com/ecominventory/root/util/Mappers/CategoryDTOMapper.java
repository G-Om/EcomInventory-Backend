package com.ecominventory.root.util.Mappers;

import com.ecominventory.root.model.entities.Category;
import com.ecominventory.root.util.DTO.CategoryDTO;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CategoryDTOMapper implements Function<Category, CategoryDTO> {

    private final ProductDTOMapper productDTOMapper = new ProductDTOMapper();

    @Override
    public CategoryDTO apply(Category categories) {
        return new CategoryDTO(
                categories.getId(),
                categories.getName(),
                categories.getProducts().stream().map(productDTOMapper).collect(Collectors.toList())
        );
    }
}

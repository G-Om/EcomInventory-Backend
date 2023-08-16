package com.ecominventory.root.util.DTO;

import java.util.List;

public record ProductDTO (
        Long id,
        String name,
        Integer price,
        Integer quantity,
        String description,
        String image,
        List<String> categories){
}

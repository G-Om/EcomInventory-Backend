package com.ecominventory.root.util.DTO;

import java.util.List;

public record CategoryDTO(
        Long id,
        String name,
        List<ProductDTO> products
) {
}

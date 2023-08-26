package com.ecominventory.root.util.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    private Long userId;
    private Long productId;
    private int quantity;
}

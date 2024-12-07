package com.ecommerce.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class ItemRequest {
    private String productId;
    private int quantity;
}

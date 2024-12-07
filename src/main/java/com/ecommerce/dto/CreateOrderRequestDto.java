package com.ecommerce.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class CreateOrderRequestDto {
    private String userId;
    private List<ItemRequest> items;
    private String shippingAddress;
    private String paymentMethod;
}


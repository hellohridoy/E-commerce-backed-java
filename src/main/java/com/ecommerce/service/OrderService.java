package com.ecommerce.service;

import com.ecommerce.dto.CreateOrderRequestDto;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.entity.Orderx;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface OrderService {

    OrderDto createOrder(CreateOrderRequestDto request);

    OrderDto getOrderById(Long orderId);

    List<OrderDto> listOrders(String userId, int page, int limit);

    OrderDto updateOrderStatus(Long orderId, String status);
}

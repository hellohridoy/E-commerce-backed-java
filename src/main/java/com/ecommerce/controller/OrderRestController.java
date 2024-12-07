package com.ecommerce.controller;

import com.ecommerce.dto.CreateOrderRequestDto;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.dto.UpdateOrderStatusRequest;
import com.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderRestController {

    private final OrderService orderService;



    @PostMapping("/v1/api/order/order-infos")
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderRequestDto request) {
        OrderDto order = orderService.createOrder(request);
        return ResponseEntity.status(201).body(order);
    }

    @GetMapping("/v1/api/order/order-infos/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/v1/api/order/order-infos")
    public ResponseEntity<List<OrderDto>> listOrders(
            @RequestParam(required = false) String userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        List<OrderDto> orders = orderService.listOrders(userId, page, limit);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/v1/api/order/order-infos/{orderId}")
    public ResponseEntity<OrderDto> updateOrderStatus(
            @PathVariable Long orderId, @RequestBody UpdateOrderStatusRequest request) {
        OrderDto updatedOrder = orderService.updateOrderStatus(orderId, request.getStatus());
        return ResponseEntity.ok(updatedOrder);
    }
}


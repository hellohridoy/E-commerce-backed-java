package com.ecommerce.service;

import com.ecommerce.dto.CreateOrderRequestDto;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Orderx;
import com.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;


    @Override
    public OrderDto createOrder(CreateOrderRequestDto request) {
        Orderx order = new Orderx();
        order.setUserId(request.getUserId());
        order.setShippingAddress(request.getShippingAddress());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setStatus("Pending");

        final Orderx finalOrder = order; // Make it effectively final

// Map ItemDto to OrderItem
        Set<OrderItem> orderItems = (Set<OrderItem>) request.getItems().stream().map(itemDto -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(itemDto.getProductId());
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setOrderx(finalOrder); // Use the final variable
            return orderItem;
        }).collect(Collectors.toList());

        order.setItems(orderItems);
        order = orderRepository.save(order);

        return new OrderDto(order);

    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Orderx order = orderRepository.findById(orderId)
                .orElseThrow();
        return new OrderDto(order);
    }

    @Override
    public List<OrderDto> listOrders(String userId, int page, int limit) {
        Page<Orderx> orders = (userId != null)
                ? orderRepository.findByUserId(userId, PageRequest.of(page - 1, limit))
                : orderRepository.findAll(PageRequest.of(page - 1, limit));

        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrderStatus(Long orderId, String status) {
        Orderx order = orderRepository.findById(orderId)
                .orElseThrow();

        order.setStatus(status);
        order = orderRepository.save(order);

        return new OrderDto(order);
    }
}

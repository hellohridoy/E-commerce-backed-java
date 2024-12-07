package com.ecommerce.entity;


import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import java.util.List;
import java.util.Set;

@Entity
@Data
public class Orderx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String shippingAddress;
    private String paymentMethod;
    private String status;

    @OneToMany(mappedBy = "orderx")
    private Set<OrderItem> items;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Getters and Setters
    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
}

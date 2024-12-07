package com.ecommerce.entity;


import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Orderx> orders;
}


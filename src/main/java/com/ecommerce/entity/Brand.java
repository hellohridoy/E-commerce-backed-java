package com.ecommerce.entity;


import jakarta.persistence.*;


import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;

    // Getters and setters omitted for brevity
}

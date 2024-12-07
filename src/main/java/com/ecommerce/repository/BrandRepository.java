package com.ecommerce.repository;

import com.ecommerce.entity.Brand;
import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {}

package com.ecommerce.repository;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Orderx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orderx, Long> {
    Page<Orderx> findByUserId(String userId, PageRequest of);
}

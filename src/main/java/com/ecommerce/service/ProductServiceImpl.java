package com.ecommerce.service;


import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


        @Override
        public List<ProductDto> getAllProductsList() {
            return productRepository.findAll().stream()
                    .map(product -> new ProductDto(
                            product.getId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice()
                    ))
                    .collect(Collectors.toList());
        }
    }


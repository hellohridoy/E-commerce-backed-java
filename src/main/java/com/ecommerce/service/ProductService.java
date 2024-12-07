package com.ecommerce.service;


import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;

import java.util.List;


public interface ProductService {

     Product getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<ProductDto> getAllProductsList();

}

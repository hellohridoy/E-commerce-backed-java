package com.ecommerce.service;

import com.ecommerce.dto.CategoryDto;
import com.ecommerce.dto.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto createCategory(CreateCategoryRequest request);
    CategoryDto updateCategory(Long categoryId, CreateCategoryRequest request);
    void deleteCategory(Long categoryId);
}

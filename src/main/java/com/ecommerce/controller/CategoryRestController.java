package com.ecommerce.controller;

import com.ecommerce.dto.CategoryDto;
import com.ecommerce.dto.CreateCategoryRequest;
import com.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService categoryService;

    @GetMapping("/v1/api/category/category-infos")
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/v1/api/category/category-infos")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CreateCategoryRequest request) {
        CategoryDto category = categoryService.createCategory(request);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/v1/api/category/category-infos/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long categoryId, @RequestBody CreateCategoryRequest request) {
        CategoryDto category = categoryService.updateCategory(categoryId, request);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/v1/api/category/category-infos/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}


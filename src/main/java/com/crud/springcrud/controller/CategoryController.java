package com.crud.springcrud.controller;

import com.crud.springcrud.dto.CategoryDTO;
import com.crud.springcrud.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createNew(@RequestBody CategoryDTO model) {
        CategoryDTO result = categoryService.save(model);
        return ResponseEntity.ok(result);
    }

}

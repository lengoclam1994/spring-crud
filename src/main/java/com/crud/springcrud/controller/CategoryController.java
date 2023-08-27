package com.crud.springcrud.controller;

import com.crud.springcrud.dto.CategoryDTO;
import com.crud.springcrud.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/category")
    public CategoryDTO createNew(@RequestBody CategoryDTO model) {
        return categoryService.save(model);
    }
}

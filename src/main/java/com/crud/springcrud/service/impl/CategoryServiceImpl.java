package com.crud.springcrud.service.impl;

import com.crud.springcrud.dto.CategoryDTO;
import com.crud.springcrud.entity.CategoryEntity;
import com.crud.springcrud.mapper.CategoryMapper;
import com.crud.springcrud.repository.CategoryRepository;
import com.crud.springcrud.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO model) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(model);
        categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(categoryEntity);
    }
}

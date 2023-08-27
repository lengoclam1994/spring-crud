package com.crud.springcrud.service.impl;

import com.crud.springcrud.dto.NewDTO;
import com.crud.springcrud.entity.CategoryEntity;
import com.crud.springcrud.entity.NewEntity;
import com.crud.springcrud.mapper.NewMapper;
import com.crud.springcrud.repository.CategoryRepository;
import com.crud.springcrud.repository.NewRepository;
import com.crud.springcrud.service.NewService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements NewService {

    private final   NewRepository newRepository;

    private final CategoryRepository categoryRepository;

    private final NewMapper newMapper;

    public NewServiceImpl(NewRepository newRepository, CategoryRepository categoryRepository, NewMapper newMapper) {
        this.newRepository = newRepository;
        this.categoryRepository = categoryRepository;
        this.newMapper = newMapper;
    }

    @Override
    public NewDTO save(NewDTO model) {
        NewEntity newEntity;
        if (model.getId() != null) {
            NewEntity oldNewEntity = newRepository.findById(model.getId()).get();
            newEntity = newMapper.toEntity(model, oldNewEntity);
        } else {
            newEntity = newMapper.toEntity(model);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(model.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newMapper.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        if (ids.length < 1) return;
        for (long id : ids) {
            newRepository.deleteById(id);
        }
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        return newRepository.findAll(pageable).getContent().stream().map((item) -> newMapper.toDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewDTO> findAll() {
        return newRepository.findAll().stream().map((item) -> newMapper.toDTO(item)).collect(Collectors.toList());
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }
}

package com.crud.springcrud.service;

import com.crud.springcrud.dto.NewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewService {
    NewDTO save(NewDTO model);

    void delete(long[] ids);

    Page<NewDTO> findAll(Pageable pageable);

    List<NewDTO> findAll();
}

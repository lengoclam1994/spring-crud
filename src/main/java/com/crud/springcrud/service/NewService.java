package com.crud.springcrud.service;

import com.crud.springcrud.dto.NewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewService {
    NewDTO save(NewDTO model);

    void delete(long[] ids);

    List<NewDTO> findAll(Pageable pageable);

    List<NewDTO> findAll();

    int totalItem();
}

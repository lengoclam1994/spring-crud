package com.crud.springcrud.dto;

import lombok.Data;

@Data
public class CategoryDTO extends BaseDTO<CategoryDTO>{

    private String code;
    private String name;
}

package com.crud.springcrud.dto;

import lombok.Data;

@Data
public class NewDTO extends BaseDTO<NewDTO> {

    private String title;
    private String content;
    private String shortDescription;
    private String categoryCode;
    private String thumbnail;
}

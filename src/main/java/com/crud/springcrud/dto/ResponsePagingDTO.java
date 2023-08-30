package com.crud.springcrud.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponsePagingDTO {

    private int page;
    private int totalPage;
    private List<NewDTO> listResult = new ArrayList<>();
}

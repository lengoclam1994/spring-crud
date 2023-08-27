package com.crud.springcrud.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewOutputDTO {

    private int page;
    private int totalPage;
    private List<NewDTO> listResult = new ArrayList<>();
}

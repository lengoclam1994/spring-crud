package com.crud.springcrud.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BaseDTO<T> {

    private Long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private List<T> listResult = new ArrayList<>();
}

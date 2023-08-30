package com.crud.springcrud.service;

import com.crud.springcrud.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity addEmployee(EmployeeEntity employee);

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity findEmployeeById(Integer id);

    EmployeeEntity updateEmployee(EmployeeEntity employee);

    boolean deleteEmployeeById(Integer id);
}

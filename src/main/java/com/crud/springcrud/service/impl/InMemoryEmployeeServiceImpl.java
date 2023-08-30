package com.crud.springcrud.service.impl;

import com.crud.springcrud.entity.EmployeeEntity;
import com.crud.springcrud.repository.InMemoryEmployeeRepository;
import com.crud.springcrud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "inMemoryEmpService")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;
    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return inMemoryEmployeeRepository.getAllEmployee();
    }

    @Override
    public EmployeeEntity findEmployeeById(Integer id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        return employee;
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        return inMemoryEmployeeRepository.deleteEmployeeById(id);
    }
}

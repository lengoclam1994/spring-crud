package com.crud.springcrud.service.impl;

import com.crud.springcrud.entity.EmployeeEntity;
import com.crud.springcrud.repository.EmployeeRepository;
import com.crud.springcrud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "jpaEmpService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        return employee;
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }
}

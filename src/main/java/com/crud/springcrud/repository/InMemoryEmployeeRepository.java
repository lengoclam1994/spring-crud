package com.crud.springcrud.repository;

import com.crud.springcrud.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<EmployeeEntity> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(EmployeeEntity.builder().id(1).firstName("Le").lastName("Lam").email("lam@gmail.com").build());
        DATABASE.add(EmployeeEntity.builder().id(2).firstName("Tran").lastName("Thu").email("thu@gmail.com").build());
        DATABASE.add(EmployeeEntity.builder().id(3).firstName("Pham").lastName("Duyen").email("duyen@gmail.com").build());
    }

    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        DATABASE.add(employee);
        return employee;
    }

    public List<EmployeeEntity> getAllEmployee() {
        return List.copyOf(DATABASE);
    }

    public EmployeeEntity findById(Integer id) {
        return DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst().orElseThrow();
    }

    public void updateEmployee(EmployeeEntity employee) {

    }

    public boolean deleteEmployeeById(Integer id) {
        EmployeeEntity employee = DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst().orElseThrow();
        return DATABASE.remove(employee);
    }
}

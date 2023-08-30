package com.crud.springcrud.controller;

import com.crud.springcrud.entity.EmployeeEntity;
import com.crud.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier(value = "jpaEmpService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employee) {
        employee.setId(employeeService.getAllEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }

    @PutMapping
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee) {
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.updateEmployee(employee));

    }

    private URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}

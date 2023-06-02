package org.example.controller;

import org.example.dao.EmployeeDao;
import org.example.dto.Employee;
import org.example.dto.Employees;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeService service;

    @PostMapping(path="/register",consumes = "Application/json",produces = "Application/json")
    public ResponseEntity<Employee> registerEmployee(@Valid @RequestBody Employee employee) {
        URI location = service.registerEmployee(employee);
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/list",produces = "Application/json")
    public Employees getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
}

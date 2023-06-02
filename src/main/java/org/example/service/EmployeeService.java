package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public URI registerEmployee(Employee employee){

        Integer id = employeeDao.getAllEmployees().getEmployeeList().size()+1;
        employee.setId(id);
        employeeDao.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return location;
    }
}

package com.usa.employee.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.usa.employee.model.Employee;

public interface EmployeeService {
    Employee createEmployee( @RequestBody Employee reqEmployee);
}

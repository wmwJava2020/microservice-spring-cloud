package com.usa.employee.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.employee.model.Employee;
import com.usa.employee.utility.EmployeeUtility;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Map<String, Employee> empMap;

	EmployeeUtility utils;

	public EmployeeServiceImpl() {
	}

	//Constructor based injections
	@Autowired
	public EmployeeServiceImpl(EmployeeUtility utils) {
		this.utils = utils;
	}

	@Override
	public Employee createEmployee(Employee reqEmployee) {

		Employee employeePost = new Employee();

		employeePost.setName(reqEmployee.getName());
		employeePost.setDept(reqEmployee.getDept());
		employeePost.setAge(reqEmployee.getAge());
		employeePost.setEmail(reqEmployee.getEmail());
		employeePost.setPassword(reqEmployee.getPassword());
		employeePost.setDateTime(reqEmployee.getDateTime());

		String employeeId = utils.createEMployeesUUID();
		employeePost.setId(employeeId);

		if (empMap == null)
			empMap = new HashMap<>();
		empMap.put(employeeId, employeePost);

		return employeePost;
	}

}

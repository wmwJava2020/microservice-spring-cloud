package com.usa.employee.utility;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EmployeeUtility {
	public String createEMployeesUUID() {
		String utils = UUID.randomUUID().toString();
		return utils;
	}
}

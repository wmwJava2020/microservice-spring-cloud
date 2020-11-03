package com.usa.employee.controller;

import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usa.employee.model.Employee;
import com.usa.employee.model.UpdateEmployee;
import com.usa.employee.service.EmployeeService;

@RestController
@RequestMapping("employees") // http://localhost:8080/employee
public class EmployeeController {

	Map<String,Employee> empMap;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String getEmployess(@RequestParam(value = "page") int page,
			                   @RequestParam(value = "limit") int limit) {
		return "get employee data displayed with page=" + page + " and limit "+ limit;
	}

	@GetMapping(path = "/{employeeId}",produces = {MediaType.APPLICATION_XML_VALUE,
			                                       MediaType.APPLICATION_JSON_VALUE})			                                       
	public ResponseEntity<Employee> getEmployee(@PathVariable String employeeId) {
		
		//if(true) throw new UserCustomException("Customized user exception is thrown");
		
		//String str = null;
		
		//int strLength = str.length();
		 
		if(empMap.containsKey(employeeId)) 
		{
			return new ResponseEntity<Employee>(empMap.get(employeeId),HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);	
		}
		
	}

	//to create 
	@PostMapping(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
	             consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> createEmployee( @RequestBody Employee reqEmployee) {		
		
		Employee employeePost = employeeService.createEmployee(reqEmployee);	
		
		return new ResponseEntity<Employee>(employeePost,HttpStatus.OK);
		
	}

	//to update
	@PutMapping(path = "/{employeeId}",produces = {MediaType.APPLICATION_XML_VALUE,
			                                       MediaType.APPLICATION_JSON_VALUE},
                                       consumes = {MediaType.APPLICATION_XML_VALUE,
                                    		       MediaType.APPLICATION_JSON_VALUE})
	public Employee updateEmployee(@PathVariable String employeeId, @Valid @RequestBody UpdateEmployee reqEmployee) {
		Employee employeeUpdate = empMap.get(employeeId);
		employeeUpdate.setName(reqEmployee.getName());
		employeeUpdate.setDept(reqEmployee.getDept());
		
		empMap.put(employeeId, employeeUpdate);
		  
		return employeeUpdate;
	}

	
	
	@DeleteMapping(path = "/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeId) {
		
		empMap.remove(employeeId);
		
		return ResponseEntity.noContent().build(); 
		 
	}
	
	 
}

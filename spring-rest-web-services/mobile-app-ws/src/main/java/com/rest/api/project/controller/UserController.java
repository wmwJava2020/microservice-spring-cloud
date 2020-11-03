package com.rest.api.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.project.shared.dto.UserDto;
import com.rest.api.project.model.request.UserDetailsRequest;
import com.rest.api.project.model.response.UserRestResponse;
import com.rest.api.project.service.UserService;


@RestController
@RequestMapping(value="users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get user was called";
	}

	//@@ REQUESTBODY--->READS INCOMING REQUEST 
	//@@ A [UserDetailsRequest] CLASS WOULD CREATE A JAVA OBJECT FROM REQUESTBODY
	
	@PostMapping
	public UserRestResponse createUser(@RequestBody UserDetailsRequest userDatailsRequest) {
		
		//@@ INSTANTIATING USERRESTRESPONSE CLASS
		UserRestResponse returnValue = new UserRestResponse();
		
		
		//@@ CALLING USERDTO CLASS TO COPY INPUT-INFORMATION
		//@@ TO DO THIS COPY INCOMING INPUT-DATA TO TRANSFERING MIDDEL CLASS I.E. DTO
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDatailsRequest, userDto);
		
		
		//@@ PASSING INPUT-DATA INSIDE USERDTO CLASS TO A SERVICE CLASS
		//@@ AND A SERVICE CLASS WILL CREATE NEW USER FOR USING REQUESTED DATA
		//@@ ONCE USER SERVICE INTERFACE CREATED A NEW USER IT WILL RETURN BACK TO USERDOT CLASS
		//@@ AND USERDTO CLASS WILL ASLO RETURN A CREATE CONFIRMATION TO USERRESTRESPONSE CLASS.
		UserDto userCreated = userService.createUser(userDto);
		BeanUtils.copyProperties(userCreated, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "update user user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	} 
 
}

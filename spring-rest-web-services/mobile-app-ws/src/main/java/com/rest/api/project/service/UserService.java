package com.rest.api.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rest.api.project.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
	
	UserDto createUser(UserDto user);

}

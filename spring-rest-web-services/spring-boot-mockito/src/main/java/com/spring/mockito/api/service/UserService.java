package com.spring.mockito.api.service;

import org.springframework.stereotype.Service;

import com.spring.mockito.api.model.User;

@Service
public class UserService {

	User addUser(User user) {
		return user;

	};

}

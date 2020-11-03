package com.rest.api.project.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rest.api.project.entity.UserEntity;
import com.rest.api.project.repository.UserRepository;
import com.rest.api.project.service.UserService;
import com.rest.api.project.shared.Utils;
import com.rest.api.project.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserRepository userRepository;
    
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
    Utils utils;


	@Override
	public UserDto createUser(UserDto user) {
		
		//@@ PREVENT DOUBLE ENTRY OF THE USERS DATA INTO DATABASE.
		if(userRepository.findByEmail(user.getEmail())!= null) 
			throw new RuntimeException("USER ALREADY EXSIST, PLEASE TRY WITH DIFFERENT EMAIL ID...");
		
		//@@ ENTITY CLASS IS INSTANTIATED
		//@@ TO COPY DATA FROM INPUT-USER TO DESTINATION USERENTITYCLASS.
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
				
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		//@@ CALL AND REPOSITORY INTERFACE AND PASS DATA TO BE PERSISITED
		UserEntity savedUsers = userRepository.save(userEntity);
		
		//@@ COPY PERSISTED USERS TO USERDTO FOR TRANSFERING DATA
		UserDto returnValue = new UserDto();  
		BeanUtils.copyProperties(savedUsers, returnValue);
		
		return returnValue; 
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
 
} 
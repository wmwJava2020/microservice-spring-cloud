package com.addis.usersmicorservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.addis.usersmicorservice.models.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

	// CREATING CUSTOM METHOD findByEmail
	UserEntity findByEmail(String email); 
	UserEntity findByUserId(String userId);
}

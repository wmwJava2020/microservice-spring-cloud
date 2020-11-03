package com.rest.api.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.project.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	//@@ WE CAN CREATE A CUSTOM METHOD IF WE NEED IT SHOULD RETURN USERENTITY OBJECT.
	//@@ WE ALSO CAN PASS RESPECTIVE OBJECT TO BE SEARCHED
	//@@ REPOSITORY INTERFACE ONLY EMBADED --> findAll,findById,saveAll....
	UserEntity findUserByLastName(String lastName);
	UserEntity findByEmail(String email);
	void deleteUserByLastName(long userId);

}

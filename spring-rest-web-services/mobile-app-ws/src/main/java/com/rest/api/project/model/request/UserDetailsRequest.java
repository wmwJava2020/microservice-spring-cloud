package com.rest.api.project.model.request;

import lombok.Data;

@Data
public class UserDetailsRequest {

	//@@ THIS CLASS SHOULD MATCH INCOIMG REQUEST FIELDS
	//@@ AND CONVERT INCOMING REQUEST INTO JAVA OBJECTS
	//@@ INFORMATION ABOUT CREATING NEW USER DATA
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}

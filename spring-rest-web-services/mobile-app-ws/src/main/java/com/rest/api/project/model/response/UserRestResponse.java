package com.rest.api.project.model.response;

import lombok.Data;

@Data
public class UserRestResponse {
	
	//@@ RESPONSE DATA FOR ENDUSER
	
	private String userId;
	private String firstName;
	private String lastName;
	private String email;

}

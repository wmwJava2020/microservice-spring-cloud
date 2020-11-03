package com.addis.usersmicorservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDataModel {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
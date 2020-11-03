package com.usa.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {
    @NotNull(message="id cannot be missing or empty")
	private String id;
    @NotNull(message="name cannot be missing or empty")
	private String name;
    @NotNull
	private String dept;
	@NotNull(message="First name cannot be missing or empty")
    private int age;
	@Email
	private String email;
	@NotNull(message="Password is a required field")
	@Size(min=8,  message="Password must be greater than 8 characters")
	private String password;
	@NotNull
	private Date dateTime;
	
	
}

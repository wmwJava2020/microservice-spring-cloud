package com.spring.mockito.api.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class User {

	private int Id;
	private String name;
	private String coures;
	private float grade;
}

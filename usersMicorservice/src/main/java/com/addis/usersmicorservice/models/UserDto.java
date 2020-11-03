package com.addis.usersmicorservice.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 7157848214436543037L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String userId;
	private Date date;
	private List<AlbumsResponseModel> albums;

	

	
	
	 

}

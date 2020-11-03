package com.addis.usersmicorservice.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserResponseModle {

	//@@ THIS CALSS HAS A USERS DETAILS WE WANT TO RETURN TOGETHER WITH ALBUM 
	//@@RETURNS LIST OF ALBUMS FORM ALBUMMICORSERVICE
	private String userId;	
	private String firstName;
	private String lastName;
	private String email;
	private Date date;
	private List<AlbumsResponseModel> albums;
	
	
	
	

}

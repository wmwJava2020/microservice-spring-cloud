package com.addis.usersmicorservice.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseEntityModle {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private List<AlbumsResponseModel> albumModel;

}

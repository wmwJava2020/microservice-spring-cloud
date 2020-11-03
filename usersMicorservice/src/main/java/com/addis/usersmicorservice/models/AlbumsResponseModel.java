package com.addis.usersmicorservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlbumsResponseModel {
	
	// THIS CALSS CONTIANS DETAILS OF ALBUMS JSON RESPONSE/ LIST OF FEILDES INCLUDED IN ALBUMS RESPONSE
		private int albumId;
		private String userId;
		private String name;
		private String description;

}

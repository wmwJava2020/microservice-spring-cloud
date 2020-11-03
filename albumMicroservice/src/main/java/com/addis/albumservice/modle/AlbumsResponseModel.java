package com.addis.albumservice.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlbumsResponseModel {
	
	private int albumId;
    private String userId; 
    private String name;
    private String description;

}

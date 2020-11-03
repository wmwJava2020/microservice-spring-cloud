package com.addis.albumservice.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlbumEntity {

	private long id;
    private String albumId;
    private Long userId; 
    private String name;
    private String description;
}

package com.addis.albumservice.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.addis.albumservice.modle.AlbumEntity;
import com.addis.albumservice.modle.AlbumsResponseModel;
import com.addis.albumservice.service.AlbumService;
import com.google.common.reflect.TypeToken;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumController {

	@Autowired
	AlbumService albumService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("serial")
	@GetMapping
	public List<AlbumsResponseModel> getAlbums(@PathVariable String id) {

		List<AlbumsResponseModel> albumModel = new ArrayList<AlbumsResponseModel>();

		List<AlbumEntity> album = albumService.getAlbum(id);

		if (album == null || album.isEmpty()) {
			
			return albumModel;
		}
 		
		Type listType = new TypeToken<List<AlbumsResponseModel>>(){}.getType();
	
        albumModel = new ModelMapper().map(album, listType);
        
        logger.info("Returning " + albumModel.size() + " albums");
        
		return albumModel;

	}

}

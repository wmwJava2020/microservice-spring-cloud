package com.addis.albumservice.service;

import java.util.List;

import com.addis.albumservice.modle.AlbumEntity;

public interface AlbumService {
	
	List<AlbumEntity> getAlbum(String Long);

}

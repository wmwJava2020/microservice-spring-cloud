package com.addis.albumservice.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addis.albumservice.modle.AlbumEntity;

@Service
public class AlbumServiceImpl implements AlbumService {

	//@Autowired
	//AlbumRepository albumRepository;

	@Override
	public List<AlbumEntity> getAlbum(String Long) {

		ArrayList<AlbumEntity> albumList = new ArrayList<AlbumEntity>();

		AlbumEntity returnAlbum = new AlbumEntity();
		returnAlbum.setAlbumId(Long);
		returnAlbum.setName("U 10");
		returnAlbum.setDescription("POP style");
		returnAlbum.setUserId(2L);

		AlbumEntity returnAlbum0 = new AlbumEntity();
		returnAlbum0.setAlbumId(Long);
		returnAlbum0.setName("U 11");
		returnAlbum0.setDescription("Solo style");
		returnAlbum0.setUserId(2L);
		
		AlbumEntity returnAlbum1 = new AlbumEntity();
		returnAlbum1.setAlbumId(Long);
		returnAlbum1.setName("U 12");
		returnAlbum1.setDescription("Oldes style");
		returnAlbum1.setUserId(2L);
		
		AlbumEntity returnAlbum2 = new AlbumEntity();
		returnAlbum2.setAlbumId(Long);
		returnAlbum2.setName("U R");
		returnAlbum2.setDescription("Rapp style");
		returnAlbum2.setUserId(2L);

		albumList.add(returnAlbum);
		albumList.add(returnAlbum0);
		albumList.add(returnAlbum1);
		albumList.add(returnAlbum2);

		return albumList;
	}

}

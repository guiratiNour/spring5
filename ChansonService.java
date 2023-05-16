package com.nour.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nour.demo.entities.Album;
import com.nour.demo.entities.Chanson;


public interface ChansonService {
	Chanson saveChanson(Chanson p);
	Chanson updateChanson(Chanson p);
	void deleteChanson(Chanson p);
	 void deleteChansonById(Long id);
	 Chanson getChanson(Long id);
	List<Chanson> getAllChansons();
	Page<Chanson> getAllChansonsParPage(int page, int size);
	List<Chanson> findByAlbum (Album album);
	List<Chanson> findByAlbumIdAlbum(Long idChanson);
	 List<Album> getAllAlbums();
	 List<Chanson> findByNomContains(String nom);
 
}

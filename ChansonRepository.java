package com.nour.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nour.demo.entities.Album;
import com.nour.demo.entities.Chanson;

@RepositoryRestResource(path = "rest")
public interface ChansonRepository extends JpaRepository<Chanson, Long> {
    @Query("SELECT c FROM Chanson c WHERE c.album = ?1")
    List<Chanson> findByAlbum(Album album);

    List<Chanson> findByAlbumIdalbum(Long id);

    List<Chanson> findByNomContains(String nom);
}

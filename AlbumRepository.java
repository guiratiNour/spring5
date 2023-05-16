package com.nour.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nour.demo.entities.Album;
@RepositoryRestResource(path = "cat")
@CrossOrigin ("http://localhost:4200/") //pour autoriser angular

public interface AlbumRepository extends JpaRepository<Album, Long> {

}

package com.nour.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nour.demo.entities.Album;
import com.nour.demo.entities.Chanson;
import com.nour.demo.repos.ChansonRepository;
import com.nour.demo.repos.AlbumRepository;

@Service
public class ChansonServiceImpl implements ChansonService {
    @Autowired
    ChansonRepository chansonRepository;
    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Chanson saveChanson(Chanson p) {
        return chansonRepository.save(p);
    }

    @Override
    public Chanson updateChanson(Chanson p) {
        return chansonRepository.save(p);
    }

    @Override
    public void deleteChanson(Chanson p) {
        chansonRepository.delete(p);
    }

    @Override
    public void deleteChansonById(Long id) {
        chansonRepository.deleteById(id);
    }

    @Override
    public Chanson getChanson(Long id) {
        return chansonRepository.findById(id).get();
    }

    @Override
    public List<Chanson> getAllChansons() {
        return chansonRepository.findAll();
    }

    @Override
    public Page<Chanson> getAllChansonsParPage(int page, int size) {
        return chansonRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Chanson> findByAlbum(Album album) {
        return chansonRepository.findByAlbum(album);
    }

    @Override
    public List<Chanson> findByAlbumIdAlbum(Long id) {
        return chansonRepository.findByAlbumIdalbum(id);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public List<Chanson> findByNomContains(String nom) {
        return chansonRepository.findByNomContains(nom);
    }

}

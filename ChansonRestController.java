package com.nour.demo.restcontollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nour.demo.entities.Chanson;
import com.nour.demo.services.ChansonService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ChansonRestController {
	@Autowired
	ChansonService chansonService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Chanson> getAllChansons() {
	return chansonService.getAllChansons();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Chanson getChansonsById(@PathVariable("id") Long id) {
	return chansonService.getChanson(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Chanson createChanson(@RequestBody Chanson chanson) {
	return chansonService.saveChanson(chanson);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Chanson updateChanson(@RequestBody Chanson chanson) {
	return chansonService.updateChanson(chanson);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteChanson(@PathVariable("id") Long id)
	{
		chansonService.deleteChansonById(id);
	}
	@RequestMapping(value="/chAlbum/{idAlbum}",method = RequestMethod.GET)
	public List<Chanson> getChansonsByCatId(@PathVariable("idalbum") Long idAlbum) {
	return chansonService.findByAlbumIdAlbum(idAlbum);
	}
	@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
	public List<Chanson> findByNomChansonContains(@PathVariable("nom") String nom) {
	return chansonService.findByNomContains(nom);





}}

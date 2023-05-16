package com.nour.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalbum;
	private String nom;
	private String nomChanseur;
	
	@OneToMany(mappedBy="album")
	@JsonIgnore
	private List<Chanson> chansons;
	public Album() {}
	public Album(String nom, String nomChanseur, List<Chanson> chansons) {
		super();
		this.nom = nom;
		this.nomChanseur = nomChanseur;
		this.chansons = chansons;
	}
	public Long getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(Long idalbum) {
		this.idalbum = idalbum;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNomChanseur() {
		return nomChanseur;
	}
	public void setNomChanseur(String nomChanseur) {
		this.nomChanseur = nomChanseur;
	}
	public List<Chanson> getChansons() {
		return chansons;
	}
	public void setChansons(List<Chanson> chansons) {
		this.chansons = chansons;
	}
	@Override
	
	public String toString() {
	    return "Album [idAlbum=" + idalbum + ", nom=" + nom + "]";
	}

	
	
}

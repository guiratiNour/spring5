package com.nour.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
public class Chanson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChanson;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
private Date dateCreation;
	@NotNull
	
    @Size (min=4,max=15)
	private String nom;
	
	
	
	@ManyToOne
	private Album album;
	public Chanson() {
		super();
		
	}
	public Chanson(Date dateCreation, String nom, com.nour.demo.entities.Album album) {
		super();
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.album = album;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Long getIdChanson() {
		return idChanson;
	}
	public void setIdChanson(Long idChanson) {
		this.idChanson = idChanson;
	}
	@Override
	public String toString() {
		return "Chanson [idChanson=" + idChanson + ", dateCreation=" + dateCreation + ", nom=" + nom + ", album="
				+ album + "]";
	}
	
}
package com.nour.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nom", types = { Chanson.class })
public interface ChansonProjection {
	public String getNom();

}

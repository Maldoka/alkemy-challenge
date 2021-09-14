package com.disney.proy.builders;

import java.util.Date;

import com.disney.proy.dto.PeliculaSerieResponseDto;
import com.disney.proy.model.PeliculaSerie;

public class PeliculaSerieResponseBuilder {
	
	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	
	
	public PeliculaSerieResponseBuilder whithPeliculaSerieResponseDto(PeliculaSerie peliculaSerie) {
		this.imagen=peliculaSerie.getImagen();
		this.titulo=peliculaSerie.getTitulo();
		this.fechaCreacion=peliculaSerie.getFechaCreacion();
		return this;
	}


	public PeliculaSerieResponseDto build() {
		return new PeliculaSerieResponseDto (this.imagen, this.titulo, this.fechaCreacion);
	}
}



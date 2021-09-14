package com.disney.proy.builders;

import java.util.Date;

import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.model.PeliculaSerie;

public class PeliculaSerieBuilder {
	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;

	public PeliculaSerieBuilder whitPeliculaSerieDto(PeliculaSerieDto peliculaSerieDto) {
		this.imagen = peliculaSerieDto.getImagen();
		this.titulo = peliculaSerieDto.getTitulo();
		this.fechaCreacion = peliculaSerieDto.getFechaCreacion();
		this.calificacion = peliculaSerieDto.getCalificacion();
		return this;
	}

	public PeliculaSerie build() {
		return new PeliculaSerie(this.imagen, this.titulo, this.fechaCreacion, this.calificacion);
	}
}

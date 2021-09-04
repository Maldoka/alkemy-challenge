package com.disney.proy.dto;

import java.util.Date;

public class PeliculaSerieDto {
	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;
	private int idGenero;
	private int idPersonaje;
	
	
	public PeliculaSerieDto(String imagen, String titulo, Date fechaCreacion, int calificacion, int idGenero,
			int idPersonaje) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.idGenero = idGenero;
		this.idPersonaje = idPersonaje;
	}



	public int getIdGenero() {
		return idGenero;
	}



	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}



	public int getIdPersonaje() {
		return idPersonaje;
	}



	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}



	public PeliculaSerieDto() {
		
	}



	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	

}

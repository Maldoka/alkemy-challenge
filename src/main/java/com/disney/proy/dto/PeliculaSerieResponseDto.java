package com.disney.proy.dto;

import java.util.Date;

public class PeliculaSerieResponseDto {

	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	
	
	
	public PeliculaSerieResponseDto(String imagen, String titulo, Date fechaCreacion) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
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
	
	
	
}

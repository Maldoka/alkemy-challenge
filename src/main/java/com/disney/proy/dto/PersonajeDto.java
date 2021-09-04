package com.disney.proy.dto;

import java.util.Set;

import com.disney.proy.model.PeliculaSerie;

public class PersonajeDto {

	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;
	
	private Set<PeliculaSerie> peliculaSerie;
	
	

	public PersonajeDto() {
		
	}
	
	public PersonajeDto(String nombre, String imagen, int edad, float peso, String historia) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}

	public Set<PeliculaSerie> getPeliculaSerie() {
		return peliculaSerie;
	}

	public void setPeliculaSerie(Set<PeliculaSerie> peliculaSerie) {
		this.peliculaSerie = peliculaSerie;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	
	
}

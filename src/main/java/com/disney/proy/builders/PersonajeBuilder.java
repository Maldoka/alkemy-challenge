package com.disney.proy.builders;

import com.disney.proy.dto.PersonajeDto;
import com.disney.proy.model.Personaje;

public class PersonajeBuilder {
	
	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;

	public PersonajeBuilder whithPersonajeDto(PersonajeDto personajeDto) {
		this.nombre=personajeDto.getNombre();
		this.imagen=personajeDto.getImagen();
		this.edad=personajeDto.getEdad();
		this.peso=personajeDto.getPeso();
		this.historia=personajeDto.getHistoria();
		return this;
	}
	

	
	public Personaje build() {
		return new Personaje(this.nombre, this.imagen,this.edad,this.peso,this.historia);
	}

}

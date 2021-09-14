package com.disney.proy.builders;

import com.disney.proy.dto.PersonajeResponseDto;
import com.disney.proy.model.Personaje;

public class PersonajeResponseBuilder {
	
	private String nombre;
	private String imagen;
	
	
	public PersonajeResponseBuilder whithPersonajeResponseDto(Personaje personaje) {
		this.nombre=personaje.getNombre();
		this.imagen=personaje.getImagen();
		return this;
	}


	public PersonajeResponseDto build() {
		return new PersonajeResponseDto (this.nombre, this.imagen);
	}
}

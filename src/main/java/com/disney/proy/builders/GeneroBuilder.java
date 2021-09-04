package com.disney.proy.builders;

import com.disney.proy.dto.GeneroDto;
import com.disney.proy.model.Genero;

public class GeneroBuilder {
	private String nombre;
	private String imagen;
	
	public GeneroBuilder withGeneroDto(GeneroDto generoDTO) {
		this.nombre = generoDTO.getNombre();
		this.imagen = generoDTO.getImagen();
		return this;
	}
	
	public Genero build() {
		return new Genero(this.nombre, this.imagen);
	}
}

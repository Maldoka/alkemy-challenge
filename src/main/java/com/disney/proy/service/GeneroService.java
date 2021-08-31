package com.disney.proy.service;

import com.disney.proy.model.Genero;

public interface GeneroService {
	/**
	 * Obtiene un registro segun su ID
	 * 
	 * @param id El ID del registro que se quiere buscar
	 * @return
	 */
	public Genero getById(Integer id);
	public Genero getByImagen(String imagen);
}

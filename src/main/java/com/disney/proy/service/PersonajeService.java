package com.disney.proy.service;

import java.util.Collection;
import java.util.List;

import com.disney.proy.dto.GeneroDto;
import com.disney.proy.dto.PersonajeDto;
import com.disney.proy.model.Genero;
import com.disney.proy.model.Personaje;

public interface PersonajeService {

	public Personaje findById(Integer id);
	public List<Personaje> findAll();
	public Personaje save(PersonajeDto personaje);
	public Personaje update(Integer id, PersonajeDto personajeDTO);
	public void delete(Integer id);

}

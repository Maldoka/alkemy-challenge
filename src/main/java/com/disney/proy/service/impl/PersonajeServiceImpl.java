package com.disney.proy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.proy.builders.GeneroBuilder;
import com.disney.proy.builders.PersonajeBuilder;
import com.disney.proy.dto.GeneroDto;
import com.disney.proy.dto.PersonajeDto;
import com.disney.proy.model.Genero;
import com.disney.proy.model.Personaje;
import com.disney.proy.repository.PeliculaSerieRepository;
import com.disney.proy.repository.PersonajeRepository;
import com.disney.proy.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService {
	@Autowired
	private PersonajeRepository personajeRepository;

	@Override
	public List<Personaje>findAll(){
		return personajeRepository.findAll();
	}
	@Override
	public Personaje findById(Integer id) {
		return personajeRepository.findById(id).orElse(null);
	}

	@Override
	public Personaje save(PersonajeDto personajeDTO) {
		Personaje personaje = new PersonajeBuilder().whithPersonajeDto(personajeDTO).build();
		return personajeRepository.save(personaje);
	}
	
	@Override
	public Personaje update(Integer id, PersonajeDto personajeDTO) {
		Personaje personaje = personajeRepository.findById(id).get();
		
		personaje.setImagen(personajeDTO.getImagen());
		personaje.setNombre(personajeDTO.getNombre());
		
		return personajeRepository.save(personaje);
	}
	
	@Override
	public void delete(Integer id) {
		personajeRepository.deleteById(id);
	}

}

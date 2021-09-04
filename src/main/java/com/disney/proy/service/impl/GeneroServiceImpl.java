package com.disney.proy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.proy.builders.GeneroBuilder;
import com.disney.proy.dto.GeneroDto;
import com.disney.proy.model.Genero;
import com.disney.proy.repository.GeneroRepository;
import com.disney.proy.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {
	@Autowired
	private GeneroRepository generoRepository;

	@Override
	public Genero findById(Integer id) {
		return generoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}

	@Override
	public Genero save(GeneroDto generoDTO) {
		Genero genero = new GeneroBuilder().withGeneroDto(generoDTO).build();
		return generoRepository.save(genero);
	}
	
	@Override
	public Genero update(Integer id, GeneroDto generoDTO) {
		Genero genero = generoRepository.findById(id).get();
		
		genero.setImagen(generoDTO.getImagen());
		genero.setNombre(generoDTO.getNombre());
		
		return generoRepository.save(genero);
	}
	
	@Override
	public void delete(Integer id) {
		generoRepository.deleteById(id);
	}
}

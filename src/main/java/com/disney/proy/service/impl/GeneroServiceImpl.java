package com.disney.proy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.proy.model.Genero;
import com.disney.proy.repository.GeneroRepository;
import com.disney.proy.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {
	@Autowired
	private GeneroRepository generoRepository;

	@Override
	public Genero getById(Integer id) {
		return generoRepository.findById(id).orElse(null);
	}

	@Override
	public Genero getByImagen(String imagen) {
		return (Genero) generoRepository.findByImagen(imagen);
	}
}

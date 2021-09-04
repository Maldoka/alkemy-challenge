package com.disney.proy.service;

import java.util.List;

import com.disney.proy.dto.GeneroDto;
import com.disney.proy.model.Genero;

public interface GeneroService {
	public Genero findById(Integer id);
	public List<Genero> findAll();
	public Genero save(GeneroDto genero);
	public Genero update(Integer id, GeneroDto generoDTO);
	public void delete(Integer id);
}

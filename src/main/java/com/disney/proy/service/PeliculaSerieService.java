package com.disney.proy.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.model.PeliculaSerie;


public interface PeliculaSerieService {


	public  PeliculaSerie findById(Integer id);
	public List<PeliculaSerie> findAll();
	public void delete(Integer id);
	public PeliculaSerie save(PeliculaSerieDto peliculaSerieDTO);
	public PeliculaSerie update(Integer id, PeliculaSerieDto peliculaSerieDto);
	
	public List<PeliculaSerie> findByTitulo(String titulo);

	public List<PeliculaSerie> findByGenero(Integer idGenero);
	
	public List<PeliculaSerie> findAll(Sort orden);
	
}

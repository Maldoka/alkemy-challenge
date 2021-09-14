package com.disney.proy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.disney.proy.builders.PeliculaSerieBuilder;
import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.model.PeliculaSerie;
import com.disney.proy.repository.GeneroRepository;
import com.disney.proy.repository.PeliculaSerieRepository;
import com.disney.proy.repository.PersonajeRepository;
import com.disney.proy.service.PeliculaSerieService;

@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService {
	@Autowired
	private PeliculaSerieRepository peliculaSerieRepository;

	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Override
	public List<PeliculaSerie> findByTitulo(String titulo){
		return peliculaSerieRepository.findByTitulo(titulo);
	}
	
	@Override
	public List<PeliculaSerie> findByGenero(Integer idGenero){
		return peliculaSerieRepository.findByGenero(idGenero);
	}
	
	@Override
	public PeliculaSerie findById(Integer id) {
		return peliculaSerieRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<PeliculaSerie> findAll(Sort orden){
		return peliculaSerieRepository.findAll(orden);
	}

	public PeliculaSerie save(PeliculaSerieDto peliculaSerieDTO) {
		PeliculaSerie peliculaSerie = new PeliculaSerieBuilder().whitPeliculaSerieDto(peliculaSerieDTO).build();
		peliculaSerie.getGeneros().add(generoRepository.findById(peliculaSerieDTO.getIdGenero()).get());
		peliculaSerie.getPersonajes().add(personajeRepository.findById(peliculaSerieDTO.getIdPersonaje()).get());
		return peliculaSerieRepository.save(peliculaSerie);
	}

	@Override
	public List<PeliculaSerie> findAll() {
		return peliculaSerieRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
	peliculaSerieRepository.deleteById(id);		
	}
	
	@Override
	public PeliculaSerie update(Integer id, PeliculaSerieDto peliculaSerieDTO) {
		PeliculaSerie peliculaSerie= peliculaSerieRepository.findById(id).get();
		
		peliculaSerie.setImagen(peliculaSerieDTO.getImagen());
		peliculaSerie.setTitulo(peliculaSerieDTO.getTitulo());
		peliculaSerie.setFechaCreacion(peliculaSerie.getFechaCreacion());
		peliculaSerie.setCalificacion(peliculaSerieDTO.getCalificacion());
		
		return peliculaSerieRepository.save(peliculaSerie);
	}
	

}

package com.disney.proy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.model.PeliculaSerie;


public interface PeliculaSerieService {


	public  PeliculaSerie findById(Integer id);
	public List<PeliculaSerie> findAll();
	public void delete(Integer id);
	public PeliculaSerie save(PeliculaSerieDto peliculaSerieDTO);

}

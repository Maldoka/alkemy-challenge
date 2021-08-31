package com.disney.proy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.proy.repository.PeliculaSerieRepository;
import com.disney.proy.service.PeliculaSerieService;

@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService {
@Autowired
private PeliculaSerieRepository peliculaSerieRepository;
@Override
public void get() {
	peliculaSerieRepository.findById(null);
}

}

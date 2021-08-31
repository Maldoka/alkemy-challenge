package com.disney.proy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.disney.proy.model.Genero;
import com.disney.proy.service.GeneroService;

@Controller
public class GeneroController {
	@Autowired
	private GeneroService generoService;
	
	/*
	 * Defino un endpoint /generos/{id}, que busca
	 * y devuelve un Genero segun su ID
	 */
	@RequestMapping(value = "/generos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Genero> findById(@PathVariable("id") Integer id) {
		Genero generoHallado = generoService.getById(id);
		
		return new ResponseEntity<Genero>(generoHallado, HttpStatus.OK);
	}
	
}

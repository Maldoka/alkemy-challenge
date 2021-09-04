package com.disney.proy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.proy.dto.GeneroDto;
import com.disney.proy.model.Genero;
import com.disney.proy.service.GeneroService;

@RestController
@RequestMapping("/genero")
@CrossOrigin("*")
public class GeneroController {
	@Autowired
	private GeneroService generoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findGeneroById(@PathVariable(value = "id") Integer id) {
		Genero genero = generoService.findById(id);
		return new ResponseEntity<>(genero, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(generoService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveGenero(@RequestBody GeneroDto generoDTO) {
		Genero nuevoGenero = generoService.save(generoDTO);
		return new ResponseEntity<>(nuevoGenero, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateGenero(@PathVariable(value = "id") Integer id, @RequestBody GeneroDto generoDTO) {
		return new ResponseEntity<>(generoService.update(id, generoDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGenero(@PathVariable(value = "id") Integer id) {
		generoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

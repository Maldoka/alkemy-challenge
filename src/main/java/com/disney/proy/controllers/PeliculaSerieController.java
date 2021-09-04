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

import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.model.PeliculaSerie;
import com.disney.proy.service.PeliculaSerieService;

@RestController
@RequestMapping("/peliculaSerie")
@CrossOrigin("*")
public class PeliculaSerieController {
	@Autowired
	private PeliculaSerieService peliculaSerieService;

	@PostMapping
	public ResponseEntity<?> savePeliculaSerie(@RequestBody PeliculaSerieDto peliculaSerieDto) {
		PeliculaSerie peliculaSerie = peliculaSerieService.save(peliculaSerieDto);
		return new ResponseEntity<>(peliculaSerie, HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<?>findAllPeliculaSerie(){
		return new ResponseEntity<>(peliculaSerieService.findAll(), HttpStatus.OK);
	}
	
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?>updadtePeliculaSerie(@PathVariable(value="id")Integer id,@RequestBody PeliculaSerieDto peliculaSerieDto){
//		return new ResponseEntity<>(PeliculaSerieService.update(id,peliculaSerieDto), HttpStatus.OK);
//	}
//	
//	@DeleteMapping
//	public ResponseEntity<?>deletePeliculaSerie(@PathVariable(value="id")Integer id){
//		PeliculaSerieService.delete(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

}

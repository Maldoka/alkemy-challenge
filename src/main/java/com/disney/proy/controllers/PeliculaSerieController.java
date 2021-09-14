package com.disney.proy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.dto.PeliculaSerieResponseDto;
import com.disney.proy.model.PeliculaSerie;
import com.disney.proy.service.PeliculaSerieService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class PeliculaSerieController {
	@Autowired
	private PeliculaSerieService peliculaSerieService;

	@PostMapping
	public ResponseEntity<?> savePeliculaSerie(@RequestBody PeliculaSerieDto peliculaSerieDto) {
		PeliculaSerie peliculaSerie = peliculaSerieService.save(peliculaSerieDto);
		return new ResponseEntity<>(peliculaSerie, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?>findPeliculaSerieById(@PathVariable(value="id") Integer id){
		PeliculaSerie peliculaSerie = peliculaSerieService.findById(id);
		return new ResponseEntity<>(peliculaSerie, HttpStatus.OK);
	}


	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(name="name", required=false) String titulo , @RequestParam(name="genre", required=false) Integer idGenero, @RequestParam(name="order", required= false) String order) {
		List<PeliculaSerie> lista = new ArrayList<PeliculaSerie>();
		if(titulo != null) {
			lista = peliculaSerieService.findByTitulo(titulo);
		} 	
		else  if(idGenero !=null){
			lista = peliculaSerieService.findByGenero(idGenero);

		}
		else if (order != null) { 
			if (order.toLowerCase().equals("desc")) {
				lista = peliculaSerieService.findAll(Sort.by(Sort.Direction.DESC, "fechaCreacion"));
			}else {
				lista = peliculaSerieService.findAll(Sort.by(Sort.Direction.ASC, "fechaCreacion"));

			}
		}
		else {
			lista = peliculaSerieService.findAll();
		}
		List<PeliculaSerieResponseDto> listaParaDevolver = new ArrayList<PeliculaSerieResponseDto>();

		for(PeliculaSerie p : lista) {
			listaParaDevolver.add(new PeliculaSerieResponseDto(p.getImagen(), p.getTitulo(), p.getFechaCreacion()));
		}

		return new ResponseEntity<>(listaParaDevolver, HttpStatus.OK);
	}


		@PutMapping("/{id}")
		public ResponseEntity<?> updatePeliculaSerie(@PathVariable(value= "id") Integer id,@RequestBody PeliculaSerieDto peliculaSerieDto){
			return new ResponseEntity<>(peliculaSerieService.update(id, peliculaSerieDto), HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?>deletePeliculaSerie(@PathVariable(value="id")Integer id){
			peliculaSerieService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

}


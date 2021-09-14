package com.disney.proy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.disney.proy.dto.PersonajeDto;
import com.disney.proy.dto.PersonajeResponseDto;
import com.disney.proy.model.Personaje;
import com.disney.proy.service.PersonajeService;

@Controller
@RequestMapping("/characters")
@CrossOrigin("*")
public class PersonajeController {
	@Autowired
	private PersonajeService personajeService;
	
	
	@PostMapping
	public ResponseEntity<?> savePersonaje(@RequestBody PersonajeDto personajeDTO) {
		Personaje nuevoPersonaje = personajeService.save(personajeDTO);
		return new ResponseEntity<>(nuevoPersonaje, HttpStatus.CREATED);
	}


	@GetMapping("/{id}")
	public ResponseEntity<?> findPersonajeById(@PathVariable(value = "id") Integer id) {
		Personaje personaje = personajeService.findById(id);
		return new ResponseEntity<>(personaje, HttpStatus.OK);
	}

		@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(name = "name", required= false) String nombre, @RequestParam(name="age", required=false)Integer edad, @RequestParam(name="movies", required=false)Integer idPeliculaSerie) {
		List<Personaje> lista = new ArrayList<Personaje>();
		if(nombre != null) { 
			lista = personajeService.findByNombre(nombre);

		}else if(edad != null) {
			lista= personajeService.findByEdad(edad);
		} else if(idPeliculaSerie != null) {
			lista = personajeService.findByPeliculaSerie(idPeliculaSerie);
			}
		
		else {
			
			lista = personajeService.findAll(); 
		}
		List<PersonajeResponseDto> listaParaDevolver = new ArrayList<PersonajeResponseDto>();

		for(Personaje p : lista) {
			listaParaDevolver.add(new PersonajeResponseDto(p.getNombre(), p.getImagen()));
		}

		return new ResponseEntity<>(listaParaDevolver, HttpStatus.OK);
	}


	@PutMapping("/{id}")
	public ResponseEntity<?> updatePersonaje(@PathVariable(value = "id") Integer id, @RequestBody PersonajeDto personajeDTO) {
		return new ResponseEntity<>(personajeService.update(id, personajeDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable(value = "id") Integer id) {
		personajeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}

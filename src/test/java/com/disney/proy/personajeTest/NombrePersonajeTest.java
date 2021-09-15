package com.disney.proy.personajeTest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.disney.proy.model.Personaje;
import com.disney.proy.repository.PersonajeRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NombrePersonajeTest {
	
	
	@Autowired
	PersonajeRepository personajeRepository;
			
	@Test
	 public void buscoPersonajePorId_dadoUnId_entoncesRetornoUnPersonaje() {
		Personaje personaje = new Personaje("Sol","assests/t.jpg",20,3,"algo.");
		Integer idPersonaje=4;
		
		personajeRepository.save(personaje);
		
		Personaje hallado = personajeRepository.findById(idPersonaje).orElse(null);
		
		Assertions.assertThat(hallado.getNombre()).isEqualTo("Sol");
		Assertions.assertThat(hallado.getEdad()).isEqualTo(20);
		Assertions.assertThat(hallado.getPeso()).isEqualTo(3);
		Assertions.assertThat(hallado.getHistoria()).isEqualTo("algo.");
	
	
	}
 
    
		
	}



package com.disney.proy.generoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.disney.proy.model.Genero;
import com.disney.proy.repository.GeneroRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GeneroRepositoryTest {
 
  @Autowired
  GeneroRepository generoRepository;
 
  @Test
  public void cuandoBuscoGeneroPorId_dadoUnId_entoncesRetornarGenero() {
    Genero genero = new Genero("Terror", "/assets/images/1.png");
    Integer idGenero = 2;    
    
    generoRepository.save(genero);
    
    Genero hallado = generoRepository.findById(idGenero).orElse(null);

    Assertions.assertThat(hallado.getNombre()).isEqualTo("Terror");
    Assertions.assertThat(hallado.getImagen()).isEqualTo("/assets/images/1.png");
    }
}

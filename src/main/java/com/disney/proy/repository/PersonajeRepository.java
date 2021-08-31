package com.disney.proy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.proy.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer>  {

}

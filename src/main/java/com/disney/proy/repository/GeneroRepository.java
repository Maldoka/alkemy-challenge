package com.disney.proy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.proy.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{
}	

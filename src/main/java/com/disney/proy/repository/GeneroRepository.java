package com.disney.proy.repository;

import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.proy.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{
	@Query("SELECT nombre FROM Genero WHERE imagen = :imagen")
	Future<String> findByImagen(@Param("imagen") String imagen);
}	

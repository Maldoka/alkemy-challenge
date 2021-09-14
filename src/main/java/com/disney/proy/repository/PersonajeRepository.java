package com.disney.proy.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.proy.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer>
 {
	public List<Personaje> findByNombre(String nombre);
	public List<Personaje> findByEdad(int edad);
	
	@Query(value = "select * from personajes p inner join peliculaserie_personaje pp on p.id_personaje = pp.id_personaje inner join pelicula_serie ps on pp.id_pelicula_serie = ps.id_pelicula_serie where ps.id_pelicula_serie = (:idPeliculaSerie)", nativeQuery = true)
	public List<Personaje> findByPeliculaSerie(@Param("idPeliculaSerie")Integer idPeliculaSerie);
}

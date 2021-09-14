package com.disney.proy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney.proy.dto.PeliculaSerieDto;
import com.disney.proy.model.PeliculaSerie;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Integer> {
	PeliculaSerie save(PeliculaSerieDto peliculaSerie);
	
	public List<PeliculaSerie> findByTitulo(String nombre);
	
	@Query(value ="SELECT * FROM pelicula_serie ps INNER JOIN peliculaserie_genero pg ON ps.id_pelicula_serie  = pg.id_pelicula_serie INNER JOIN genero g ON (pg.id_genero) = (g.id_genero) WHERE (g.id_genero) = (:idGenero)", nativeQuery=true)	
	public List<PeliculaSerie> findByGenero(@Param("idGenero")Integer idGenero);
	

	
	
	
}

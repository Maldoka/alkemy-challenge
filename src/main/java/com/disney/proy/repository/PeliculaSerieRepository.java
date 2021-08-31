package com.disney.proy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.proy.model.PeliculaSerie;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Integer> {

}

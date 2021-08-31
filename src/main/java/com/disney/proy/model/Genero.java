package com.disney.proy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Genero {
	@Column
	private String nombre;
	@Column(name="id_genero")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenero;
	@Column
	private String imagen;
	@Column(name="pelicula_serie")
	private int peliculaSerie;
	
	   @ManyToMany(mappedBy = "generos")
	    private Set<PeliculaSerie> peliculasSeries = new HashSet<>();


	public Genero(String nombre, Integer idGenero, String imagen, int peliculaSerie,
			Set<PeliculaSerie> peliculasSeries) {
		super();
		this.nombre = nombre;
		this.idGenero = idGenero;
		this.imagen = imagen;
		this.peliculaSerie = peliculaSerie;
		this.peliculasSeries = peliculasSeries;
	}

	public Genero() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPeliculaSerie() {
		return peliculaSerie;
	}

	public void setPeliculaSerie(int peliculaSerie) {
		this.peliculaSerie = peliculaSerie;
	}


}

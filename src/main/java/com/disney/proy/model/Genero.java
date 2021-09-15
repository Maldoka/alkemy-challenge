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

	@Column(name = "id_genero")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_genero;

	@Column
	private String imagen;

	@ManyToMany(mappedBy = "generos")
	private Set<PeliculaSerie> peliculasSeries = new HashSet<>();

	public Genero(String nombre, String imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public Genero() {}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdGenero() {
		return id_genero;
	}

	public void setIdGenero(Integer idGenero) {
		this.id_genero = idGenero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


}

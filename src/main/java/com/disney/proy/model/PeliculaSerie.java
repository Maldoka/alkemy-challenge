package com.disney.proy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pelicula_serie")
public class PeliculaSerie {
	private String imagen;
	private Integer idPeliculaSerie;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;

	private Set<Personaje> personajes;
	private Set<Genero> generos;

	
	public PeliculaSerie() {
		
	}

	public PeliculaSerie(String imagen, String titulo, Date fechaCreacion, int calificacion) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.generos = new HashSet<Genero>();
		this.personajes = new HashSet<Personaje>();
	}

	@Column
	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	@Column
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "id_pelicula_serie")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPeliculaSerie() {
		return idPeliculaSerie;
	}

	public void setIdPeliculaSerie(Integer idPeliculaSerie) {
		this.idPeliculaSerie = idPeliculaSerie;
	}

	@Column
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "fecha_creacion")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "peliculaserie_personaje", joinColumns = @JoinColumn(name = "id_pelicula_serie"), inverseJoinColumns = @JoinColumn(name = "id_personaje"))
	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "peliculaserie_genero", joinColumns = @JoinColumn(name = "id_pelicula_serie"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}
}

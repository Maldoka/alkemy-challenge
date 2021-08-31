package com.disney.proy.model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table (name="pelicula_serie")
public class PeliculaSerie {
	@Column
	private String imagen;
	@Column(name="id_pelicula_serie")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idPeliculaSerie;
	@Column
	private String titulo;
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	@Column
	private int calificacion;
	@Column(name="personajes_asociados")
	private int personajesAsociados;

	
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "peliculaSerie_personaje",
	        joinColumns = @JoinColumn(name = "peliculaSerie_id", referencedColumnName = "id_pelicula_serie"),
	        inverseJoinColumns = @JoinColumn(name = "personaje_id", referencedColumnName = "id_Personaje"))
	    private Set<Personaje> personajes;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "peliculaSerie_genero",
	        joinColumns = @JoinColumn(name = "peliculaSerie_id", referencedColumnName = "id_pelicula_serie"),
	        inverseJoinColumns = @JoinColumn(name = "idGenero", referencedColumnName = "id_genero"))
	    private Set<Genero> generos;
	
	

	public PeliculaSerie(String imagen, Integer idPeliculaSerie, String titulo, Date fechaCreacion, int calificacion,
			int personajesAsociados, Set<Personaje> personajes, Set<Genero> generos) {
		super();
		this.imagen = imagen;
		this.idPeliculaSerie = idPeliculaSerie;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.personajesAsociados = personajesAsociados;
		this.personajes = personajes;
		this.generos = generos;
	}
	public PeliculaSerie() {

	}
	public int getCalificacion() {
		return calificacion;	
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Integer getIdPeliculaSerie() {
		return idPeliculaSerie;
	}
	public void setIdPeliculaSerie(Integer idPeliculaSerie) {
		this.idPeliculaSerie = idPeliculaSerie;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getPersonajesAsociados() {
		return personajesAsociados;
	}

	public void setPersonajesAsociados(int personajesAsociados) {
		this.personajesAsociados = personajesAsociados;
	}


}

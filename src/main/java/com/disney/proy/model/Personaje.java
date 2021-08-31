package com.disney.proy.model;

import java.util.ArrayList;
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

import java.util.List;


@Entity
@Table(name="personajes")
public class Personaje {
	@Column
	private String nombre;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id_personaje;
	
	@Column()
	private int imagen;
	@Column()
	private int edad;
	@Column()
	private float peso;
	@Column()
	private String historia;
	@Column(name ="pelicula_serie")
	private int peliculaSerie;
	
//@ManyToMany(cascade=CascadeType.ALL)
//@JoinTable(name="personaje_peliculaSerie",
//joinColumns= {@JoinColumn(name="id_personaje")},
//inverseJoinColumns= {@JoinColumn(name="id_pelicula_serie")})
//private List<PeliculaSerie> peliSerie= new ArrayList<PeliculaSerie>();
	
    @ManyToMany(mappedBy = "personajes")
    private Set<PeliculaSerie> peliculasSeries = new HashSet<>();

	public Personaje(String nombre, Integer id_personaje, int imagen, int edad, float peso, String historia,
			int peliculaSerie, Set<PeliculaSerie> peliculasSeries) {
		super();
		this.nombre = nombre;
		this.id_personaje = id_personaje;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculaSerie = peliculaSerie;
		this.peliculasSeries = peliculasSeries;
	}


	public Personaje() {
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getId_personaje() {
		return id_personaje;
	}
	public void setId_personaje(Integer id_personaje) {
		this.id_personaje = id_personaje;
	}
	public int getImagen() {
		return imagen;
	}
	public void setImagen(int imagen) {
		this.imagen = imagen;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public int getPeliculaSerie() {
		return peliculaSerie;
	}
	public void setPeliculaSerie(int peliculaSerie) {
		this.peliculaSerie = peliculaSerie;
	}

}

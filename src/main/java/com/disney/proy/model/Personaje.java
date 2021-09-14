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
@Table(name = "personajes")
public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_personaje;

	@Column
	private String nombre;

	@Column()
	private String imagen;
	
	@Column()
	private int edad;
	
	@Column()
	private float peso;
	
	@Column()
	private String historia;

	@ManyToMany(mappedBy = "personajes")
	private Set<PeliculaSerie> peliculasSeries = new HashSet<>();
	
	


	public Personaje(String nombre, String imagen, int edad, float peso, String historia) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
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

}

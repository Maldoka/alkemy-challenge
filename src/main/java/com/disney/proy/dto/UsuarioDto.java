	package com.disney.proy.dto;

public class UsuarioDto {
	
	private String username;
	private String clave;
	private String correo;
	private String nombre;
	private String apellido;
	
	
	
	public UsuarioDto() {
		
	}


	public UsuarioDto(String username, String clave, String correo, String nombre, String apellido) {
		super();
		this.username = username;
		this.clave = clave;
		this.correo = correo;
		this.nombre=nombre;
		this.apellido = apellido;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}

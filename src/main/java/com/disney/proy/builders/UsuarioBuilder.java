package com.disney.proy.builders;

import com.disney.proy.dto.UsuarioDto;
import com.disney.proy.model.Usuario;

public class UsuarioBuilder {
	
	private String username;
	private String clave;
	private String correo;
	private String nombre;
	private String apellido;
	
	
	
	public UsuarioBuilder whithUsuarioDto(UsuarioDto usuarioDto) {
		this.username= usuarioDto.getUsername();
		this.clave= usuarioDto.getClave();
		this.correo= usuarioDto.getCorreo();
		this.nombre= usuarioDto.getNombre();
		this.apellido= usuarioDto.getApellido();
		return this;
	}
	public Usuario build() {
		return new Usuario (this.username, this.clave, this.correo, this.nombre, this.apellido);
	}

}

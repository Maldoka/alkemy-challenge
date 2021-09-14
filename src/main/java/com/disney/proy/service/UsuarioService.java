package com.disney.proy.service;

import com.disney.proy.dto.UsuarioDto;
import com.disney.proy.model.Usuario;

public interface UsuarioService {

	public Usuario findByNombreUsuario(String username);
	public Usuario save(UsuarioDto usuarioDto);
}

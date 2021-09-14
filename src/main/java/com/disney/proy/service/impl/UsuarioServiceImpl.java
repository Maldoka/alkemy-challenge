package com.disney.proy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.disney.proy.builders.UsuarioBuilder;
import com.disney.proy.dto.UsuarioDto;
import com.disney.proy.model.Usuario;
import com.disney.proy.repository.UsuarioRepository;
import com.disney.proy.service.EnviarMailService;
import com.disney.proy.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnviarMailService enviarMailService;
	
	@Override
	public Usuario findByNombreUsuario(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		return usuario;
	}

	@Override
	public Usuario save(UsuarioDto usuarioDto) {
		Usuario usuario = new UsuarioBuilder().whithUsuarioDto(usuarioDto).build();
		usuario = usuarioRepository.save(usuario);
		enviarMailService.enviarMail(usuario);
		return usuario;
	}

}
